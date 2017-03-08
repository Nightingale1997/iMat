package sample;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import se.chalmers.ait.dat215.project.IMatDataHandler;

import static sample.RegisterOrLoginController.controller;

/**
 * Created by Elina Olsson on 2017-03-06.
 */
public class RegistrationController {

    static Controller controller = Controller.getThisInstance();

    @FXML
    private TextField firstName, lastName, address, postCode, city, phoneNumber, email;

    /*@FXML
    private PasswordField password;*/

    @FXML
    private void loadMyAccount() {
        controller.changeMainTo("scenes/components/myAccountWelcome.fxml");
    }

    @FXML
    private void createAccount() {
        IMatDataHandler.getInstance().getCustomer().setFirstName(firstName.getText());
        IMatDataHandler.getInstance().getCustomer().setLastName(lastName.getText());
        IMatDataHandler.getInstance().getCustomer().setAddress(address.getText());
        IMatDataHandler.getInstance().getCustomer().setPostCode(postCode.getText());
        IMatDataHandler.getInstance().getCustomer().setPostAddress(city.getText());
        IMatDataHandler.getInstance().getCustomer().setMobilePhoneNumber(phoneNumber.getText());
        IMatDataHandler.getInstance().getCustomer().setEmail(email.getText());
        //IMatDataHandler.getInstance().getUser().setPassword(password.getText());

        /*setFirstName();
        setLastName();
        setAddress();
        setPostCode();
        setCity();
        setPhoneNumber();
        setEmail();
        setPassword();*/

    }


    /* Gjorde en massa getters och setters för att kunna spara uppgifter men löste det på ett annat sättså jag tror inte att dessa metoder behövs

    private void saveInfo() {
        IMatDataHandler.getInstance().getCustomer().setAddress(address.getText());

    }


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

    public String getFirstName() {
        return firstName.getText();
    }

    public String getLastName() {
        return lastName.getText();
    }

    public String getAddress() {
        return address.getText();
    }

    public String getPostCode() {
        return postCode.getText();
    }

    public String getCity() {
        return city.getText();
    }

    public String getPhoneNumber() {
        return phoneNumber.getText();
    }

    public String getEmail() {
        return email.getText();
    }

    public String getPassword() {
        return password.getText();
    }*/
}
