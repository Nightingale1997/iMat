package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import se.chalmers.ait.dat215.project.*;

import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

public class Controller implements Initializable{
    @FXML 
    private TextField searchBar;
    
    @FXML 
    private TreeView categories;
    
    @FXML 
    private Button searchButton;
    
    @FXML 
    private ListView shoppingCart;
    
    @FXML
    private Button loginButton;
    
    @FXML
    private GridPane frame;
    
    private HashMap createHashMap() {
        HashMap categoryMap = new HashMap();
        categoryMap.put("Bär", ProductCategory.BERRY);
        categoryMap.put("Bröd", ProductCategory.BREAD);
        categoryMap.put("Kål", ProductCategory.CABBAGE);
        categoryMap.put("Citrusfrukter", ProductCategory.CITRUS_FRUIT);
        categoryMap.put("Kalla drycker", ProductCategory.COLD_DRINKS);
        
        return categoryMap;
    }

    
    @Override
    public void initialize (URL url, ResourceBundle rb) {
        frame.setVisible(true);
        categories.setRoot(createCategoryTree());
        categories.setShowRoot(false);
    }
    
    private TreeItem<String> createCategoryTree() {
        String[] greens = {"Citrusfrukter", "Exotiska frukter", "Kål", "Meloner", "Rotfrukter", "Örter"};
        TreeItem<String> tree = new TreeItem<>();
        /* creates the "roots" of the tree from where branches/leaves will branch out. */
        TreeItem<String> fruitsgreens = new TreeItem<>("Frukt och grönt");
        TreeItem<String> meats = new TreeItem<>("Kött");
        tree.getChildren().add(fruitsgreens);
        tree.getChildren().add(meats);
        for (String productCategory : greens){
            TreeItem<String> treeItem = new TreeItem<>(productCategory);
        }
        return tree;
    }
    
    private TreeItem<String> addNode(String name, TreeItem<String> parent){
        TreeItem<String> newNode = new TreeItem<>(name);
        newNode.setExpanded(true);
        parent.getChildren().add(newNode);
        return newNode;
    }

}
