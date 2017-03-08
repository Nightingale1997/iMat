package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import se.chalmers.ait.dat215.project.IMatDataHandler;

/**
 * Created by elina on 2017-03-06.
 */
public class MyAccountInformationController extends Pane{

    /*private MyAccountInformationController() {
        //saveInfo();
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

    @FXML
    private TextField firstName, lastName, address, postCode, city, phoneNumber, email;

    @FXML
    private PasswordField password;

    @FXML
    private void showInfo() {
        firstName.textProperty().set(IMatDataHandler.getInstance().getCustomer().getFirstName());
        lastName.textProperty().set(IMatDataHandler.getInstance().getCustomer().getLastName());
        address.textProperty().set(IMatDataHandler.getInstance().getCustomer().getAddress());
        postCode.textProperty().set(IMatDataHandler.getInstance().getCustomer().getPostCode());
        city.textProperty().set(IMatDataHandler.getInstance().getCustomer().getPostAddress());
        phoneNumber.textProperty().set(IMatDataHandler.getInstance().getCustomer().getMobilePhoneNumber());
        email.textProperty().set(IMatDataHandler.getInstance().getCustomer().getEmail());
        password.textProperty().set(IMatDataHandler.getInstance().getUser().getPassword());
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
        IMatDataHandler.getInstance().getUser().setPassword(password.getText());
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
        /*String informationText = "Vanliga frågor och svar.";
        loadMyAccountViews(informationText, myAccountCard.getText());*/
        controller.changeMainTo("scenes/components/myAccountCard.fxml");
    }

    @FXML
    private void loadMyAccountHistory() {
        controller.changeMainTo("scenes/components/myAccountHistory.fxml");
    }

}
