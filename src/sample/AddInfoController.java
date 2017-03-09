package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import se.chalmers.ait.dat215.project.IMatDataHandler;

/**
 * Created by Elina Olsson on 2017-03-09.
 */
public class AddInfoController {

    static Controller controller = Controller.getThisInstance();

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
        //switch ()
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
