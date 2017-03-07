package sample;

import javafx.fxml.FXML;

/**
 * Created by Elina Olsson on 2017-03-07.
 */
public class PayInvoiceLoggedInController {

    static Controller controller = Controller.getThisInstance();

    @FXML
    private void loadConfirmation() {
        controller.changeMainTo("scenes/components/confirmation.fxml");
    }
}
