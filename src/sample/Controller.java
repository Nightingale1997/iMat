package sample;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import se.chalmers.ait.dat215.project.*;

import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;

public class    Controller implements Initializable{
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
            System.out.println(productCategory);
            addNode(productCategory, fruitsgreens);
        }
        for (String productCategory : dryStuff){
            addNode(productCategory, drygoods);
        }
        return tree;
    }
    
    private TreeItem<String> addNode(String name, TreeItem<String> parent){
        TreeItem<String> newNode = new TreeItem<>(name);
        newNode.setExpanded(true);
        parent.getChildren().add(newNode);
        return newNode;
    }
    
    @FXML
    private void searchBarSearch(){
        String searchphrase = searchBar.getText();
        for (Product product : instance.getProducts()){
            if(product.toString().toLowerCase().contains(searchphrase.toLowerCase()))
                System.out.println(product);
            else{
            }
        }
    }
    
    @FXML
    private void enterSearch(KeyEvent event){
        if (event.getCode().toString().equalsIgnoreCase("ENTER")){
            searchBarSearch();
        }
    }
    
    @FXML
    private void onClick(Event event){
        Button button = (Button) event.getSource();
        button.setText(event.getSource().toString());
    }
    

}
