package sample;

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
    private Button addButton, decItem, incItem;
    
    @FXML
    private TextField addItemField;
    
    @FXML
    private Text favouriteText;

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
        ImageView imageView = (ImageView) childPane.getChildren().get(8);
        imageView.setImage(new Image(imageUrl));
    }
    
    
}
