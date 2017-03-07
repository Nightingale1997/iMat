package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * Created by flirre on 2/28/17.
 */
public class PrePaymentController {

    static Controller controller = Controller.getThisInstance();

    @FXML
    private Button yesButton, noButton;

    Stage stage;
    Parent root;

    @FXML
    private void noClick(){       
        try {
            stage = (Stage)noButton.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("scenes/sample.fxml"));
            stage.setScene(new Scene(root, 1280, 720));
        }
        catch (Exception e) {}

        stage.show();
    }

    @FXML
    private void loadPayChoice() {
        controller.changeMainTo("scenes/components/payChoice.fxml");
    }

    @FXML
    private void loadMainPageCategories() {
        controller.loadMainPageCategories();
    }
}
