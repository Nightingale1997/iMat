package sample;

import javafx.fxml.FXML;

import static sample.RegisterOrLoginController.controller;

/**
 * Created by Elina Olsson on 2017-03-06.
 */
public class RegistrationController {

    static Controller controller = Controller.getThisInstance();

    @FXML
    private void loadMyAccount() { controller.changeMainTo("scenes/components/myAccountWelcome.fxml"); }


}
