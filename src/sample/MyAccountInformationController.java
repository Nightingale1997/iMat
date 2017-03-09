package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import se.chalmers.ait.dat215.project.IMatDataHandler;

import java.io.IOException;

/**
 * Created by elina on 2017-03-06.
 */
public class MyAccountInformationController extends Pane{

    /*private MyAccountInformationController() {
        //showInfo();
        /*try {
            controller.changeMainTo("scenes/components/myAccountInformation.fxml");
            FXMLLoader loader = new FXMLLoader(getClass().getResource("scenes/components/myAccountInformation.fxml"));
            loader.setController(this);
            Pane pane = loader.load();
            this.getChildren().add(pane);
            setValues();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }*/
    static Controller controller = Controller.getThisInstance();

    static MyAccountInformationController thisInstance;
    public static MyAccountInformationController getThisInstance() {
        return thisInstance;
    }

    @FXML
    private TextField firstName, lastName, address, postCode, city, phoneNumber, email;

    /*@FXML
    private PasswordField password;*/

    @FXML
    private void showInfo() {
        firstName.textProperty().set(IMatDataHandler.getInstance().getCustomer().getFirstName());
        lastName.textProperty().set(IMatDataHandler.getInstance().getCustomer().getLastName());
        address.textProperty().set(IMatDataHandler.getInstance().getCustomer().getAddress());
        postCode.textProperty().set(IMatDataHandler.getInstance().getCustomer().getPostCode());
        city.textProperty().set(IMatDataHandler.getInstance().getCustomer().getPostAddress());
        phoneNumber.textProperty().set(IMatDataHandler.getInstance().getCustomer().getMobilePhoneNumber());
        email.textProperty().set(IMatDataHandler.getInstance().getCustomer().getEmail());
        //password.textProperty().set(IMatDataHandler.getInstance().getUser().getPassword());
    }

    @FXML
    private void saveInfo() {
        IMatDataHandler.getInstance().getCustomer().setFirstName(firstName.getText());
        IMatDataHandler.getInstance().getCustomer().setLastName(lastName.getText());
        IMatDataHandler.getInstance().getCustomer().setAddress(address.getText());
        IMatDataHandler.getInstance().getCustomer().setPostCode(postCode.getText());
        IMatDataHandler.getInstance().getCustomer().setPostAddress(city.getText());
        IMatDataHandler.getInstance().getCustomer().setMobilePhoneNumber(phoneNumber.getText());
        IMatDataHandler.getInstance().getCustomer().setEmail(email.getText());
        //IMatDataHandler.getInstance().getUser().setPassword(password.getText());
    }

    @FXML
    private void loadMyAccountWelcome() {
        controller.changeMainTo("scenes/components/myAccountWelcome.fxml");
    }

    @FXML
    private void loadMyAccountInformation() {
        controller.changeMainTo("scenes/components/myAccountInformation.fxml");
    }

    @FXML
    private void loadMyAccountCard() {
        try {
            Pane pane = FXMLLoader.load(getClass().getResource("scenes/components/myAccountCard.fxml"));
            Pane childPane = (Pane) pane.getChildren().get(4);
            System.out.println(childPane.getChildren());
            RadioButton visa = (RadioButton) childPane.getChildren().get(12);
            RadioButton masterCard = (RadioButton) childPane.getChildren().get(11);
            TextField cardNumber = (TextField) childPane.getChildren().get(9);
            TextField cardName = (TextField) childPane.getChildren().get(7);
            TextField cardCVC = (TextField) childPane.getChildren().get(5);
            ComboBox<String> cardMonth = (ComboBox) childPane.getChildren().get(3);
            ComboBox<String> cardYear = (ComboBox) childPane.getChildren().get(2);
            if ((IMatDataHandler.getInstance().getCreditCard().getCardType()).equals("Visa")) {
                masterCard.setSelected(false);
                visa.setSelected(true);
            }
            else if ((IMatDataHandler.getInstance().getCreditCard().getCardType()).equals("Mastercard")) {
                visa.setSelected(false);
                masterCard.setSelected(true);
            }

            else {
                masterCard.setSelected(false);
                visa.setSelected(false);
            }
            if (IMatDataHandler.getInstance().getCreditCard().getValidMonth() < 10) {
                cardMonth.setValue("0" + Integer.toString(IMatDataHandler.getInstance().getCreditCard().getValidMonth()));

            }
            else {
                cardMonth.setValue(Integer.toString(IMatDataHandler.getInstance().getCreditCard().getValidMonth()));
            }
            cardYear.setValue(Integer.toString(IMatDataHandler.getInstance().getCreditCard().getValidYear()));
            cardNumber.textProperty().set(IMatDataHandler.getInstance().getCreditCard().getCardNumber());
            cardName.textProperty().set(IMatDataHandler.getInstance().getCreditCard().getHoldersName());
            cardCVC.textProperty().set(""+IMatDataHandler.getInstance().getCreditCard().getVerificationCode());


            controller.setMainTo(pane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void loadMyAccountHistory() {
        controller.changeMainTo("scenes/components/myAccountHistory.fxml");
    }

}
