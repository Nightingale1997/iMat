package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import se.chalmers.ait.dat215.project.IMatDataHandler;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by elina on 2017-03-06.
 */
public class MyAccountCardController implements Initializable {

    static Controller controller = Controller.getThisInstance();
    ObservableList<String> month = FXCollections.observableArrayList("01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12");
    ObservableList<String> year = FXCollections.observableArrayList("2017", "2018", "2019", "2020", "2021", "2022");


    @FXML
    private TextField cardNumber, cardName, cardCVC;

    @FXML
    private RadioButton cardVisa, cardMastercard;

    @FXML
    private ComboBox cardMonth, cardYear;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cardMonth.getSelectionModel().select("Månad");
        cardMonth.setItems(month);
        cardYear.getSelectionModel().select("År");
        cardYear.setItems(year);
        //deliveryDay.getItems().addAll("Måndag", "Tisdag");
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
        controller.changeMainTo("scenes/components/myAccountCard.fxml");
    }

    @FXML
    private void loadMyAccountHistory() {
        controller.changeMainTo("scenes/components/myAccountHistory.fxml");
    }


    @FXML
    private void showCardInfo() {
        if ((IMatDataHandler.getInstance().getCreditCard().getCardType()).equals("Visa")) {
            cardVisa.setSelected(true);
        }

        if ((IMatDataHandler.getInstance().getCreditCard().getCardType()).equals("Mastercard")) {
            cardMastercard.setSelected(true);
        }

        cardMonth.setValue(IMatDataHandler.getInstance().getCreditCard().getValidMonth());
        cardYear.setValue(IMatDataHandler.getInstance().getCreditCard().getValidYear());

        cardNumber.textProperty().set(IMatDataHandler.getInstance().getCreditCard().getCardNumber());
        cardName.textProperty().set(IMatDataHandler.getInstance().getCreditCard().getHoldersName());
    }


    @FXML
    private void saveCardInfo() {
        if (cardVisa.isSelected()) {
            IMatDataHandler.getInstance().getCreditCard().setCardType("Visa");
        }
        if (cardMastercard.isSelected()) {
            IMatDataHandler.getInstance().getCreditCard().setCardType("Mastercard");
        }

        IMatDataHandler.getInstance().getCreditCard().setCardNumber(cardNumber.getText());
        IMatDataHandler.getInstance().getCreditCard().setHoldersName(cardName.getText());

        IMatDataHandler.getInstance().getCreditCard().setVerificationCode(Integer.parseInt(cardCVC.getText()));
        IMatDataHandler.getInstance().getCreditCard().setValidMonth(Integer.parseInt(cardMonth.getValue().toString()));
        IMatDataHandler.getInstance().getCreditCard().setValidYear(Integer.parseInt(cardYear.getValue().toString()));
    }

}
