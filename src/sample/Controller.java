package sample;

import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import se.chalmers.ait.dat215.project.*;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;

public class    Controller implements Initializable{
    /*
    @FXML skrivs för att det är element från JavaFX/Scenebuilder man jobbar med.
     */
    @FXML 
    private TextField searchBar;
    
    @FXML 
    private TreeView categories;
    
    @FXML 
    private ListView shoppingCart;
    
    @FXML
    private Button getSearchButton, loginButton, addItem, incItem, decItem, item0, item1, item2, item3, item4, item5, item6, item7, item8;
    
    @FXML
    private GridPane frame;
    
    @FXML
    private Label itemLabel, itemPriceLabel;
    
    @FXML
    private ImageView addFavourite, itemImage;        
    
    @FXML
    private Text favouriteText;
    
    @FXML
    private AnchorPane firstSearchView;        

    List<Product> currentSearch = new ArrayList<>();

    HashMap categoryHash;
    
    IMatDataHandler instance = IMatDataHandler.getInstance();


    private HashMap<String, ProductCategory> createHashMap() {
        HashMap<String, ProductCategory> categoryMap = new HashMap<String, ProductCategory>();
        categoryMap.put("Bär", ProductCategory.BERRY);
        categoryMap.put("Bröd", ProductCategory.BREAD);
        categoryMap.put("Kål", ProductCategory.CABBAGE);
        categoryMap.put("Citrusfrukter", ProductCategory.CITRUS_FRUIT);
        categoryMap.put("Kalla drycker", ProductCategory.COLD_DRINKS);
        categoryMap.put("Varma drycker", ProductCategory.HOT_DRINKS);
        categoryMap.put("Exotiska frukter", ProductCategory.EXOTIC_FRUIT);
        categoryMap.put("Fisk", ProductCategory.FISH);
        categoryMap.put("Grönsaksfrukter", ProductCategory.VEGETABLE_FRUIT);
        categoryMap.put("Kött", ProductCategory.MEAT);
        categoryMap.put("Mejeriprodukter", ProductCategory.DAIRIES);
        categoryMap.put("Meloner", ProductCategory.MELONS);
        categoryMap.put("Mjöl, socker och salt", ProductCategory.FLOUR_SUGAR_SALT);
        categoryMap.put("Nötter och frön", ProductCategory.NUTS_AND_SEEDS);
        categoryMap.put("Pasta", ProductCategory.PASTA);
        categoryMap.put("Potatis och ris", ProductCategory.POTATO_RICE);
        categoryMap.put("Rotfrukter", ProductCategory.ROOT_VEGETABLE);
        categoryMap.put("Stenfrukter", ProductCategory.FRUIT);
        categoryMap.put("Sötsaker", ProductCategory.SWEET);
        categoryMap.put("Örter", ProductCategory.HERB);
        categoryMap.put("Baljväxter", ProductCategory.POD);
        
        return categoryMap;
    }

    /*
    TODO:
    1. Listor/Vyer uppdateras dynamiskt med produkterna från sökningar.
    2.
    3.
    4.
    5.
    6.
    7.
    8.
    9.
     */
    /*
    Initierar vy, skapar en hashmap för att komma åt produkt-kategorierna. 
    Sedan skapas TreeView:en och roten döljs.
    MouseEventHandlern hanterar så man kan klicka i TreeView.
     */
    @Override
    public void initialize (URL url, ResourceBundle rb) {
        
        frame.setVisible(true);
        categoryHash = createHashMap();
        categories.setRoot(createCategoryTree());
        categories.setShowRoot(false);

        EventHandler<MouseEvent> mouseEventHandle = (MouseEvent event) -> { 
            handleMouseClicked(event);
        };
        categories.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEventHandle);
    
    }
    
    /* Code handling mouse event + TreeView found at http://stackoverflow.com/questions/15792090/javafx-treeview-item-action-event 
    * Den här koden behöver man inte nödvändigtvis förstå, den gör sitt jobb.*/
    private void handleMouseClicked(MouseEvent event) {
        Node node = event.getPickResult().getIntersectedNode();
        // Accept clicks only on node cells, and not on empty spaces of the TreeView
        if (node instanceof Text || (node instanceof TreeCell && ((TreeCell) node).getText() != null)) {
            String name = (String) ((TreeItem)categories.getSelectionModel().getSelectedItem()).getValue();
            List x = instance.getProducts((ProductCategory)categoryHash.get(name));
        }
    }
    
    
    /* TODO: Bolda de fem huvudkategorierna. */
    /*
    Listor med alla namn på kategorierna skapas.
    Ett tomt träd skapas där man sedan lägger till alla rotnoder och sedan läggs alla kategorier som ska ligga under rotnoderna.
     */
    private TreeItem<String> createCategoryTree() {
        String[] greens = {"Citrusfrukter", "Exotiska frukter", "Kål", "Meloner", "Rotfrukter", "Stenfrukter", "Rotfrukter",  "Örter"};
        String[] dryStuff = {"Mjöl, socker och salt", "Nötter och frön", "Pasta", "Potatis och ris"};
        TreeItem<String> tree = new TreeItem<>();
        /* creates the "roots" of the tree from where branches/leaves will branch out. */
        TreeItem<String> fruitsgreens = addNode("Frukt och grönt", tree);
        TreeItem<String> drygoods = addNode("Skafferi", tree);
        TreeItem<String> sweets = addNode("Sötsaker", tree);
        addNode("Kött", tree);
        addNode("Mejeriprodukter", tree);
        
        
        for (String productCategory : greens){
            addNode(productCategory, fruitsgreens);
        }
        for (String productCategory : dryStuff){
            addNode(productCategory, drygoods);
        }
        return tree;
    }
    
    /*
    Tar ett namn och en nod som ska vara nodens rot och kopplar ihop dem så man kan bygga ett träd.
     */
    private TreeItem<String> addNode(String name, TreeItem<String> parent){
        TreeItem<String> newNode = new TreeItem<>(name);
        newNode.setExpanded(true);
        parent.getChildren().add(newNode);
        return newNode;
    }
    
    /*
    Hämtar en sträng från searchBar:en som finns i JavaFX/Scenebuilder. Sedan jämför den strängen med 
    alla produkter som finns i programmet(efter att ha konverterat alla char:s till gemener) och i nuläget
    printar den ut alla produkter som matchar i terminalen.
     */
    /*
    @FXML skriver man vid metoderna för att de ska synas i Scenebuilder så man kan koppla dem
    till element där. Se exempelvis searchBar i Scenebuilder.(I "Code" dropdown menyn till höger.)
     */
    @FXML
    private void searchBarSearch(){
        String searchphrase = searchBar.getText();
        currentSearch.clear();
        for (Product product : instance.getProducts()){
            if(product.toString().toLowerCase().contains(searchphrase.toLowerCase()))
                currentSearch.add(product);
            else{
            }
        }
    }
    /*
    Kontrollerar ifall det är enter-knappen som trycks på när man är i searchBar:en.
    Om det är det så kör den searchBarSearch som finns ovan,
     */
    @FXML
    private void enterSearch(KeyEvent event){
        if (event.getCode().toString().equalsIgnoreCase("ENTER")){
            searchBarSearch();
        }
    }
    
    /*
    Sparar ned vilken knapp man tryckt på till pressedButton och sedan ändrar den(i nuläget)
    vad som står på knappen till vilken knapp knapptryckningen uppfattades ifrån.
     */
    @FXML
    private void onClick(Event event){
        Button pressedButton = (Button) event.getSource();
        pressedButton.setText(event.getSource().toString());
        System.out.println(currentSearch);
        setupSearch();
    }
    
    @FXML
    private void setupSearch(){
        Pane childPane = (Pane)firstSearchView.getChildren().get(0);
        ObservableList searchItems = childPane.getChildren();
        ImageView imageView = (ImageView)searchItems.get(0);
        String home = System.getProperty("user.home");
        imageView.setImage(new Image("file:" + home + "/.dat215/imat/images/" + currentSearch.get(0).getImageName()));
        Label label = (Label)searchItems.get(1);
        label.setText(currentSearch.get(0).getName());
        searchItems.set(1, label);
        Label priceLabel = (Label)searchItems.get(2);
        priceLabel.setText(currentSearch.get(0).getPrice() + " " + currentSearch.get(0).getUnit());
        searchItems.set(2, priceLabel);
        Text favourite = (Text)searchItems.get(7);
        //TODO:check if favourite and adjust text. 
        System.out.println(searchItems.get(7));
    }   
    
    @FXML
    private void goToPayment(){
        Stage stage;
        Parent root;
        stage=(Stage) frame.getScene().getWindow();
        try {
            System.out.println("1");
            root = FXMLLoader.load(getClass().getResource("scenes/payinfo.fxml"));
            //create a new scene with root and set the stage
            System.out.println("2");
            Scene scene = new Scene(root, 1280, 720);
            System.out.println("3");
            stage.setScene(scene);

        }
        catch (Exception e){
            System.out.println("something went wrong");
        }
        stage.show();
    }
    
    
}
