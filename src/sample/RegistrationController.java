package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import static sample.RegisterOrLoginController.controller;

/**
 * Created by Elina Olsson on 2017-03-06.
 */
public class RegistrationController {

    static Controller controller = Controller.getThisInstance();

    @FXML
    private TextField firstName, lastName, address, postCode, city, phoneNumber, email, password;

    @FXML
    private void loadMyAccount() { controller.changeMainTo("scenes/components/myAccountWelcome.fxml"); }


    private void setFirstName() {
        firstName.getText();
    }

    private void setLastName() {
        lastName.getText();
    }

    private void setAddress() {
        address.getText();
    }

    private void setPostCode() {
        postCode.getText();
    }

    private void setCity() {
        city.getText();
    }

    private void setPhoneNumber() {
        phoneNumber.getText();
    }

    private void setEmail() {
        email.getText();
    }

    private void setPassword() {
        password.getText();
    }

    public TextField getFirstName() {
        return firstName;
    }

    public TextField getLastName() {
        return lastName;
    }

    public TextField getAddress() {
        return address;
    }

    public TextField getPostCode() {
        return postCode;
    }

    public TextField getCity() {
        return city;
    }

    public TextField getPhoneNumber() {
        return phoneNumber;
    }

    public TextField getEmail() {
        return email;
    }

    public TextField getPassword() {
        return password;
    }
}
