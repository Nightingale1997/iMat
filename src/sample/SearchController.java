package sample;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.chalmers.ait.dat215.project.Product;
import se.chalmers.ait.dat215.project.ShoppingCart;
import se.chalmers.ait.dat215.project.ShoppingItem;

import java.util.ArrayList;

import static java.lang.Integer.parseInt;

/**
 * Created by flirre on 3/2/17.
 */
public class SearchController {
    @FXML
    private Pane panePane;
    
    @FXML
    private ImageView itemPic, favouriteStar;
    
    @FXML
    private Label itemName, itemPrice;
    
    @FXML
    private Button addButton, decItem;

    @FXML
    private Button incItem;
    
    @FXML
    private TextField addItemField;
    
    @FXML
    private Text favouriteText, id;

    static Controller controller = Controller.getThisInstance();

    static IMatDataHandler cartInstance = IMatDataHandler.getInstance();

    static ShoppingCart shoppingCart = cartInstance.getShoppingCart();

    public String getItemName(AnchorPane anchorPane) {
        Pane childPane = (Pane) anchorPane.getChildren().get(0);
        Label itemLabel = (Label)childPane.getChildren().get(1);
        return itemLabel.getText();
    }
    
    public void setItemName(AnchorPane anchorPane, String newName){
        Pane childPane = (Pane) anchorPane.getChildren().get(0);
        Label itemLabel = (Label)childPane.getChildren().get(1);
        itemLabel.setText(newName);
    }
    
    public Image getItemPic(AnchorPane anchorPane) {
        Pane childPane = (Pane) anchorPane.getChildren().get(0);
        ImageView imageView = (ImageView)childPane.getChildren().get(0);
        return imageView.getImage();
    }
    
    public void setItemPic(AnchorPane anchorPane, String imageUrl){
        String home = System.getProperty("user.home");
        Pane childPane = (Pane) anchorPane.getChildren().get(0);
        ImageView imageView = (ImageView) childPane.getChildren().get(0); 
        imageView.setImage(new Image("file:" + home + "/.dat215/imat/images/" + imageUrl));
    }

    public String getItemPrice(AnchorPane anchorPane) {
        Pane childPane = (Pane) anchorPane.getChildren().get(0);
        Label itemLabel = (Label)childPane.getChildren().get(2);
        return itemLabel.getText();    
    }
    
    public void setItemPrice(AnchorPane anchorPane, String newPrice){
        Pane childPane = (Pane) anchorPane.getChildren().get(0);
        Label itemLabel = (Label)childPane.getChildren().get(2);
        itemLabel.setText(newPrice.toString());
    }
    
    public void setFavouriteStar(AnchorPane anchorPane, String imageUrl){
        Pane childPane = (Pane) anchorPane.getChildren().get(0);
        ImageView imageView = (ImageView) childPane.getChildren().get(5);
        imageView.setImage(new Image(imageUrl));
    }

    public void setItemId(AnchorPane anchorPane, int id){
        Pane childPane = (Pane) anchorPane.getChildren().get(0);
        Text idText = (Text) childPane.getChildren().get(9);
        idText.setText(new Integer(id).toString());
    }

    @FXML
    public void setDefault(AnchorPane anchorPane){
        Pane childPane = (Pane) anchorPane.getChildren().get(0);
        TextField quantText = (TextField) childPane.getChildren().get(6);
        quantText.setText(new Integer(1).toString());
    }

    @FXML
    public int getItemId(AnchorPane anchorPane){
        Pane childPane = (Pane) anchorPane.getChildren().get(0);
        Text itemId = (Text) childPane.getChildren().get(9);
        return parseInt(itemId.getText());
    }
    @FXML
    public void setAddItemField(AnchorPane anchorPane, int quantity){
        Pane childPane = (Pane) anchorPane.getChildren().get(0);
        TextField quantText = (TextField) childPane.getChildren().get(6);
        quantText.setText(new Integer(quantity).toString());
    }
    @FXML
    public int getAddItemField(AnchorPane anchorPane){
        Pane childPane = (Pane) anchorPane.getChildren().get(0);
        TextField itemquantity = (TextField) childPane.getChildren().get(6);
        return parseInt(itemquantity.getText());
    }

    @FXML
    private void addToCart(Event event) {
        Button pressedButton = (Button) event.getSource();
        AnchorPane source = (AnchorPane) pressedButton.getParent().getParent();
        Product toAdd = cartInstance.getProduct(getItemId(source));
        int amount = parseInt(addItemField.getText());
        boolean founditem = false;
        for(ShoppingItem si : shoppingCart.getItems()){
            System.out.println("Hej");
            if(toAdd.equals(si.getProduct())){
                si.setAmount(si.getAmount()+amount);
                founditem = true;
            }
        }
        if(!founditem){
            shoppingCart.addProduct(toAdd, amount);
        }

        System.out.println(shoppingCart.getItems().toString());
        Controller.getThisInstance().updateCartView();
    }

    @FXML
    private void addQuantity(Event event) {

        Button pressedButton = (Button) event.getSource();
        AnchorPane source = (AnchorPane) pressedButton.getParent().getParent();
        Pane childPane = (Pane) source.getChildren().get(0);
        TextField quantText = (TextField) childPane.getChildren().get(6);
        quantText.setText(new Integer(Integer.parseInt(addItemField.getText()) + 1).toString());
    }

    @FXML
    private void removeQuantity(Event event) {

        Button pressedButton = (Button) event.getSource();
        AnchorPane source = (AnchorPane) pressedButton.getParent().getParent();
        Pane childPane = (Pane) source.getChildren().get(0);
        TextField quantText = (TextField) childPane.getChildren().get(6);
        int newvalue = 0;
        if(Integer.parseInt(addItemField.getText())<2){
            newvalue = 1;
        }
        else{
            newvalue = Integer.parseInt(addItemField.getText()) - 1;
        }

        quantText.setText(new Integer(newvalue).toString());
    }

       /*    @FXML
    private void addToCart(Event event) {
        Button pressedButton = (Button) event.getSource();
        AnchorPane source = (AnchorPane) pressedButton.getParent().getParent();
        shoppingCart.addProduct(cartInstance.getProduct(getItemId(source)));
        System.out.println(shoppingCart.getItems());
        int amount = parseInt(addItemField.getText());
        shoppingItem itemToAdd = cartInstance.getProduct(getItemId(source));
        Controller.getThisInstance().updateCartView(amount, itemToAdd);
    }*/

}
