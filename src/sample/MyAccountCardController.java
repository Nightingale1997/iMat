package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import se.chalmers.ait.dat215.project.IMatDataHandler;

import java.io.IOException;
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
    private TextField cardNumber, cardName, cardCVC, cardNumber1, cardNumber2, cardNumber3;

    @FXML
    private RadioButton cardVisa, cardMastercard;

    @FXML
    private ComboBox cardMonth, cardYear;

    @FXML
    private Text saved;


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
    public void loadMyAccountInformation() {
        try {
            Pane pane = FXMLLoader.load(getClass().getResource("scenes/components/myAccountInformation.fxml"));
            Pane childPane = (Pane) pane.getChildren().get(4);
            TextField email =(TextField) childPane.getChildren().get(3);
            email.textProperty().set(IMatDataHandler.getInstance().getCustomer().getEmail());
            TextField phoneNumber =(TextField) childPane.getChildren().get(5);
            phoneNumber.textProperty().set(IMatDataHandler.getInstance().getCustomer().getMobilePhoneNumber());
            TextField city =(TextField) childPane.getChildren().get(7);
            city.textProperty().set(IMatDataHandler.getInstance().getCustomer().getPostAddress());
            TextField postCode = (TextField) childPane.getChildren().get(9);
            postCode.textProperty().set(IMatDataHandler.getInstance().getCustomer().getPostCode());
            TextField address = (TextField) childPane.getChildren().get(11);
            address.textProperty().set(IMatDataHandler.getInstance().getCustomer().getAddress());
            TextField lastName = (TextField) childPane.getChildren().get(13);
            lastName.textProperty().set(IMatDataHandler.getInstance().getCustomer().getLastName());
            TextField firstName = (TextField) childPane.getChildren().get(15);
            firstName.textProperty().set(IMatDataHandler.getInstance().getCustomer().getFirstName());
            controller.setMainTo(pane);
        } catch (IOException e) {
            e.printStackTrace();
        }
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
    }

    @FXML
    private void loadMyAccountHistory() {
        controller.changeMainTo("scenes/components/myAccountHistory.fxml");
    }


    @FXML
    private void showCardInfo() {
        if ((IMatDataHandler.getInstance().getCreditCard().getCardType()).equals("Visa")) {
            cardMastercard.setSelected(false);
            cardVisa.setSelected(true);
        }

        if ((IMatDataHandler.getInstance().getCreditCard().getCardType()).equals("Mastercard")) {
            cardVisa.setSelected(false);
            cardMastercard.setSelected(true);
        }

        cardMonth.setValue(IMatDataHandler.getInstance().getCreditCard().getValidMonth());
        cardYear.setValue(IMatDataHandler.getInstance().getCreditCard().getValidYear());

        cardNumber.textProperty().set(IMatDataHandler.getInstance().getCreditCard().getCardNumber().toString());
        cardName.textProperty().set(IMatDataHandler.getInstance().getCreditCard().getHoldersName());
        cardCVC.textProperty().set(""+IMatDataHandler.getInstance().getCreditCard().getVerificationCode());
    }


    @FXML
    private void saveCardInfo() {
        if (cardVisa.isSelected()) {
            IMatDataHandler.getInstance().getCreditCard().setCardType("Visa");
        }
        if (cardMastercard.isSelected()) {
            IMatDataHandler.getInstance().getCreditCard().setCardType("Mastercard");
        }

        //String totalCardNumber = cardNumber.getText() + cardNumber1.getText() + cardNumber2.getText() + cardNumber3.getText();

        IMatDataHandler.getInstance().getCreditCard().setCardNumber(cardNumber.getText());
        IMatDataHandler.getInstance().getCreditCard().setHoldersName(cardName.getText());

        if (!cardCVC.getText().equals("")) {
            IMatDataHandler.getInstance().getCreditCard().setVerificationCode(Integer.parseInt(cardCVC.getText()));
        } 

        IMatDataHandler.getInstance().getCreditCard().setValidMonth(Integer.parseInt(cardMonth.getValue().toString()));
        IMatDataHandler.getInstance().getCreditCard().setValidYear(Integer.parseInt(cardYear.getValue().toString()));
        saved.setText("Sparat!");
    }

}
