package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.chalmers.ait.dat215.project.Order;

import java.util.Date;

/**
 * Created by flirre on 2/28/17.
 */
public class PrePaymentController {

    static Controller controller = Controller.getThisInstance();

    public static PrePaymentController getThisInstance() {
        return thisInstance;
    }

    static PrePaymentController thisInstance;

    @FXML
    private Button yesButton, noButton;

    Stage stage;
    Parent root;

    @FXML
    private boolean allUserInformation() {
        if (IMatDataHandler.getInstance().getCustomer().getFirstName().equals("") ||
                IMatDataHandler.getInstance().getCustomer().getLastName().equals("") ||
                IMatDataHandler.getInstance().getCustomer().getAddress().equals("") ||
                IMatDataHandler.getInstance().getCustomer().getPostCode().equals("") ||
                IMatDataHandler.getInstance().getCustomer().getPostAddress().equals("") ||
                IMatDataHandler.getInstance().getCustomer().getMobilePhoneNumber().equals("") ||
                IMatDataHandler.getInstance().getCustomer().getEmail().equals("")) {
            return false;
        }
        return true;
    }

    @FXML
    private void loadPayChoice() {
        if (!allUserInformation()) {
            controller.loadRegistration();
            //System.out.println("skicka till Mitt konto > Personuppgifter");
            //invoiceLabel.setText("Personuppgifter saknas!");
            //sendOrder.setText("Uppdatera personuppgifter");
        } else if (allUserInformation()) {
            controller.changeMainTo("scenes/components/payChoice.fxml");
        }
    }

    @FXML
    private void noClick() {
        try {
            stage = (Stage) noButton.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("scenes/sample.fxml"));
            stage.setScene(new Scene(root, 1280, 720));
        } catch (Exception e) {
        }

        stage.show();
    }

    /*@FXML
    private void loadPayChoice() {
        controller.changeMainTo("scenes/components/payChoice.fxml");
    }
    */

    @FXML
    private void loadMainPageCategories() {
        controller.loadMainPageCategories();
    }
}
