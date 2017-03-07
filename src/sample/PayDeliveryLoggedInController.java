package sample;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;

/**
 * Created by Elina Olsson on 2017-03-07.
 */
public class PayDeliveryLoggedInController {

    static Controller controller = Controller.getThisInstance();

    @FXML
    ChoiceBox deliveryDay, deliveryTime;

    @FXML
    private void loadConfirmation() {
        controller.changeMainTo("scenes/components/confirmation.fxml");
    }

    

}
