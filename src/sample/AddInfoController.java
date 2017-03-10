package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import se.chalmers.ait.dat215.project.IMatDataHandler;

/**
 * Created by Elina Olsson on 2017-03-09.
 */
public class AddInfoController {

    static Controller controller = Controller.getThisInstance();

    @FXML
    private Text error;

    @FXML
    private TextField firstName, lastName, address, postCode, city, phoneNumber, email;

    @FXML
    private void showInfo() {
        firstName.textProperty().set(IMatDataHandler.getInstance().getCustomer().getFirstName());
        lastName.textProperty().set(IMatDataHandler.getInstance().getCustomer().getLastName());
        address.textProperty().set(IMatDataHandler.getInstance().getCustomer().getAddress());
        postCode.textProperty().set(IMatDataHandler.getInstance().getCustomer().getPostCode());
        city.textProperty().set(IMatDataHandler.getInstance().getCustomer().getPostAddress());
        phoneNumber.textProperty().set(IMatDataHandler.getInstance().getCustomer().getMobilePhoneNumber());
        email.textProperty().set(IMatDataHandler.getInstance().getCustomer().getEmail());
    }

    @FXML
    private void continuePayment() {
        if(firstName.getText().equals("") ||
                lastName.getText().equals("") ||
                address.getText().equals("") ||
                postCode.getText().equals("") ||
                city.getText().equals("") ||
                phoneNumber.getText().equals("") ||
                email.getText().equals("")) {
            error.setText("Fyll i all information");
        }
        if (firstName.getText().equals("")) {
            firstName.setStyle("-fx-border-width:2px; -fx-border-radius:5px; -fx-border-color:red;");
        }
        if (lastName.getText().equals("")) {
            lastName.setStyle("-fx-border-width:2px; -fx-border-radius:5px; -fx-border-color:red;");
        }
        if (address.getText().equals("")) {
            address.setStyle("-fx-border-width:2px; -fx-border-radius:5px; -fx-border-color:red;");
        }
        if (postCode.getText().equals("")) {
            postCode.setStyle("-fx-border-width:2px; -fx-border-radius:5px; -fx-border-color:red;");
        }
        if (city.getText().equals("")) {
            city.setStyle("-fx-border-width:2px; -fx-border-radius:5px; -fx-border-color:red;");
        }
        if (phoneNumber.getText().equals("")) {
            phoneNumber.setStyle("-fx-border-width:2px; -fx-border-radius:5px; -fx-border-color:red;");
        }
        if (email.getText().equals("")) {
            email.setStyle("-fx-border-width:2px; -fx-border-radius:5px; -fx-border-color:red;");
        }



        else {
            IMatDataHandler.getInstance().getCustomer().setFirstName(firstName.getText());
            IMatDataHandler.getInstance().getCustomer().setLastName(lastName.getText());
            IMatDataHandler.getInstance().getCustomer().setAddress(address.getText());
            IMatDataHandler.getInstance().getCustomer().setPostCode(postCode.getText());
            IMatDataHandler.getInstance().getCustomer().setPostAddress(city.getText());
            IMatDataHandler.getInstance().getCustomer().setMobilePhoneNumber(phoneNumber.getText());
            IMatDataHandler.getInstance().getCustomer().setEmail(email.getText());
            controller.changeMainTo("scenes/components/payChoice.fxml");
        }

    }

}
