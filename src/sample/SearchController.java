package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
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

    public Label getItemName() {
        System.out.println(itemName);
        return itemName;
    }
}
