package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;


/**
 * Created by Elina Olsson on 2017-03-06.
 */
public class RegisterOrLoginController {

    static Controller controller = new Controller();

    @FXML
    private Button toRegistration, toLogin;

    @FXML
    private void loadRegistration() {
        controller.changeMainTo("scenes/components/register.fxml");
    }

    @FXML
    private void loadMyAccount() {
        controller.loadMyAccount();
    }

}
