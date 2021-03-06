package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Created by elina on 2017-03-06.
 */
public class PayChoiceController {


    @FXML
    private Label payHeadline, totalPrice;

    @FXML
    private ImageView payImage;

    static Controller controller = Controller.getThisInstance();

    @FXML
    private void loadPayDeliveryLoggedIn() {
        controller.changeMainTo("scenes/components/payDeliveryLoggedIn.fxml");
    }

    @FXML
    private void loadPayCardLoggedIn() {
        controller.changeMainTo("scenes/components/payCardLoggedIn.fxml");
    }

    @FXML
    private void loadPayInvoiceLoggedIn() {
        controller.changeMainTo("scenes/components/payInvoiceLoggedIn.fxml");
    }

    @FXML
    private void goBack() {
        controller.changeMainTo("scenes/components/checkout.fxml");
    }
}
