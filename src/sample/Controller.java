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
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import se.chalmers.ait.dat215.project.*;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class Controller implements Initializable {
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

    @FXML
    private Pane mainPane;

    List<Product> currentSearch = new ArrayList<>();

    HashMap categoryHash;

    IMatDataHandler instance = IMatDataHandler.getInstance();

    static SearchController searchController = new SearchController();

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
    2. Fixa kundvagnen så att den visar vad som finns i kundvagnen.
    3. Koppla "Lägg till"-knappen till lägg till funktioner.
    4. Koppla "Hjälp"-knappen så att den går till hjälpsidan.
    5. Koppla "Betala"-knappen så att den går vidare till betala-vyn.
    6. Kommentera kod.
    7. Koppla "Logga in"-knappen så att den leder till Logga-in vyn.
    8. Gör allt som jag glömt skriva här.
    9. Lös så att klick på kategorierna ger en relevant sökning.
    10. Sätt 1 till default-antal, låt det gå ner till 1 igen efter tryck på "lägg i kundvagn"
    11. Fetstilta stängda kategorier som default.
    12. 
    Läs igenom Java-Doc:en så hittar ni mycket matnyttiga funktioner för kundvagnar och dylikt.
     */
    /*
    Initierar vy, skapar en hashmap för att komma åt produkt-kategorierna. 
    Sedan skapas TreeView:en och roten döljs.
    MouseEventHandlern hanterar så man kan klicka i TreeView.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

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
            String name = (String) ((TreeItem) categories.getSelectionModel().getSelectedItem()).getValue();
            List x = instance.getProducts((ProductCategory) categoryHash.get(name));
        }
    }


    /* TODO: Bolda de fem huvudkategorierna. */
    /*
    Listor med alla namn på kategorierna skapas.
    Ett tomt träd skapas där man sedan lägger till alla rotnoder och sedan läggs alla kategorier som ska ligga under rotnoderna.
     */
    private TreeItem<String> createCategoryTree() {
        String[] greens = {"Citrusfrukter", "Exotiska frukter", "Kål", "Meloner", "Rotfrukter", "Stenfrukter", "Rotfrukter", "Örter"};
        String[] dryStuff = {"Mjöl, socker och salt", "Nötter och frön", "Pasta", "Potatis och ris"};
        TreeItem<String> tree = new TreeItem<>();
        /* creates the "roots" of the tree from where branches/leaves will branch out. */
        TreeItem<String> fruitsgreens = addNode("Frukt och grönt", tree);
        TreeItem<String> drygoods = addNode("Skafferi", tree);
        TreeItem<String> sweets = addNode("Sötsaker", tree);
        addNode("Kött", tree);
        addNode("Mejeriprodukter", tree);


        for (String productCategory : greens) {
            addNode(productCategory, fruitsgreens);
        }
        for (String productCategory : dryStuff) {
            addNode(productCategory, drygoods);
        }

        return tree;
    }

    /*
    Tar ett namn och en nod som ska vara nodens rot och kopplar ihop dem så man kan bygga ett träd.
     */
    private TreeItem<String> addNode(String name, TreeItem<String> parent) {
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
    private void searchBarSearch() {
        changeMainTo("scenes/components/searchResults.fxml");
        String searchphrase = searchBar.getText();
        currentSearch.clear();
        if (!(searchphrase.equalsIgnoreCase(""))) {
            for (Product product : instance.getProducts()) {
                if (product.toString().toLowerCase().contains(searchphrase.toLowerCase()))
                    currentSearch.add(product);
                else {
                }
            }
            addSearchHits();
        }

    }

    /*
    Kontrollerar ifall det är enter-knappen som trycks på när man är i searchBar:en.
    Om det är det så kör den searchBarSearch som finns ovan,
     */
    @FXML
    private void enterSearch(KeyEvent event) {
        if (event.getCode().toString().equalsIgnoreCase("ENTER")) {
            searchBarSearch();
        }
    }

    /*
    Sparar ned vilken knapp man tryckt på till pressedButton och sedan ändrar den(i nuläget)
    vad som står på knappen till vilken knapp knapptryckningen uppfattades ifrån.
     */
    @FXML
    private void onClick(Event event) {
        Button pressedButton = (Button) event.getSource();
        pressedButton.setText(event.getSource().toString());
        System.out.println(currentSearch);
        setupSearch();
    }

    @FXML
    private void setupSearch() {
        Pane childPane = (Pane) firstSearchView.getChildren().get(0);
        ObservableList searchItems = childPane.getChildren();
        ImageView imageView = (ImageView) searchItems.get(0);
        String home = System.getProperty("user.home");
        imageView.setImage(new Image("file:" + home + "/.dat215/imat/images/" + currentSearch.get(0).getImageName()));
        Label label = (Label) searchItems.get(1);
        label.setText(currentSearch.get(0).getName());
        searchItems.set(1, label);
        Label priceLabel = (Label) searchItems.get(2);
        priceLabel.setText(currentSearch.get(0).getPrice() + " " + currentSearch.get(0).getUnit());
        searchItems.set(2, priceLabel);
        Text favourite = (Text) searchItems.get(7);
        //TODO:check if favourite and adjust text. 
        System.out.println(searchItems.get(7));
    }


    private void addSearchHits() {
        FlowPane childPane = (FlowPane) firstSearchView.getChildren().get(0);
        childPane.getChildren().clear();
        for (int i = 0; i < currentSearch.size(); i++) {
            try {
                //FXMLLoader loader = new FXMLLoader(getClass().getResource("scenes/components/Searchresult1.fxml"));
                AnchorPane x = FXMLLoader.load(getClass().getResource("scenes/components/Searchresults1.fxml"));
                searchController.setItemName(x, currentSearch.get(i).getName());
                searchController.setItemPic(x, currentSearch.get(i).getImageName());
                searchController.setItemPrice(x, currentSearch.get(i).getPrice() + " " + currentSearch.get(i).getUnit());
                searchController.setFavouriteStar(x, "sample/img/keditbookmarks.png");
                childPane.getChildren().add(x);


            } catch (Exception e) {
                e.printStackTrace();
            }
            ;
        }
        ObservableList searchItems = childPane.getChildren();
        System.out.println(searchItems);
    }

    @FXML
    private void loadLoginOrRegister() {
        changeMainTo("scenes/components/logInOrRegister.fxml");
    }

    @FXML
    private void loadMainPageCategories() {
        changeMainTo("scenes/components/mainPageCategories.fxml");
    }

    @FXML
    private void loadHelpOverview() {
        changeMainTo("scenes/components/testHelp.fxml");
    }

    /*
    @FXML
    private void loadHelpTutorial() {
        changeMainTo("scenes/components/helpTutorial.fxml");
    }

    @FXML
    private void loadHelpFAQ() {
        changeMainTo("scenes/components/helpFAQ.fxml");
    }

    @FXML
    private void loadHelpContact() {
        changeMainTo("scenes/components/helpContact.fxml");
    }*/


    //Behöver kopplas till en "favoritknapp"
    @FXML
    private void loadFavourites() {
        changeMainTo("scenes/components/favourites.fxml");
    }


    //Laddar in aktuella sidan i huvudutrymmet
    private void changeMainTo(String path) {
        try {
            mainPane.getChildren().clear();
            mainPane.getChildren().add(FXMLLoader.load(getClass().getResource(path)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void changeMainTo2(String path) {
        try {
            mainPane.getChildren().clear();
            mainPane.getChildren().add(FXMLLoader.load(getClass().getResource(path)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void goToPayment() {
        Stage stage;
        Parent root;
        stage = (Stage) frame.getScene().getWindow();
        try {
            System.out.println("1");
            root = FXMLLoader.load(getClass().getResource("scenes/payinfo.fxml"));
            //create a new scene with root and set the stage
            System.out.println("2");
            Scene scene = new Scene(root, 1280, 720);
            System.out.println("3");
            stage.setScene(scene);

        } catch (Exception e) {
            System.out.println("something went wrong");
        }
        stage.show();
    }


}
