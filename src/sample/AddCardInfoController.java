package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import se.chalmers.ait.dat215.project.IMatDataHandler;

/**
 * Created by Elina Olsson on 2017-03-09.
 */
public class AddCardInfoController {

    /*static Controller controller = Controller.getThisInstance();
    ObservableList<String> month = FXCollections.observableArrayList("01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12");
    ObservableList<String> year = FXCollections.observableArrayList("2017", "2018", "2019", "2020", "2021", "2022");

    @FXML
    private TextField cardNumber, cardName, cardCVC;

    @FXML
    private RadioButton cardVisa, cardMastercard;

    @FXML
    private ComboBox cardMonth, cardYear;

    @FXML
    private void continuePayment() {
        IMatDataHandler.getInstance().getCreditCard().setCardNumber(cardNumber.getText());
        IMatDataHandler.getInstance().getCreditCard().setHoldersName(cardName.getText());
        //IMatDataHandler.getInstance().getCreditCard().setVerificationCode(Integer.parseInt(cardCVC.getText()));
        if(cardVisa.isSelected()) {
            IMatDataHandler.getInstance().getCreditCard().setCardType("Visa");
        }
        if(cardMastercard.isSelected()) {
            IMatDataHandler.getInstance().getCreditCard().setCardType("Mastercard");
        }

    }

    @FXML
    private void showInfo() {
        //cardNumber.setText(IMatDataHandler.getInstance().getCreditCard().getCardNumber());
        cardNumber.textProperty().set(IMatDataHandler.getInstance().getCreditCard().getCardNumber());
        cardName.textProperty().set(IMatDataHandler.getInstance().getCreditCard().getHoldersName());

    }

    @FXML
    private void radioMastercard() {
        if(cardVisa.isSelected()) {
            cardVisa.setSelected(false);
        }
    }

    @FXML
    private void radioVisa() {
        if(cardMastercard.isSelected()) {
            cardMastercard.setSelected(false);
        }
    }*/

}
