package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.text.Text;
import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.chalmers.ait.dat215.project.Order;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

/**
 * Created by Elina Olsson on 2017-03-07.
 */
public class PayCardLoggedInController implements Initializable {

    static Controller controller = Controller.getThisInstance();

    @FXML
    private Text text;


    @FXML
    private boolean allUserInformation() {
        if (IMatDataHandler.getInstance().getCustomer().getFirstName().equals("") ||
                IMatDataHandler.getInstance().getCustomer().getLastName().equals("") ||
                IMatDataHandler.getInstance().getCustomer().getAddress().equals("") ||
                IMatDataHandler.getInstance().getCustomer().getPostCode().equals("") ||
                IMatDataHandler.getInstance().getCustomer().getPostAddress().equals("") ||
                IMatDataHandler.getInstance().getCustomer().getMobilePhoneNumber().equals("") ||
                IMatDataHandler.getInstance().getCustomer().getEmail().equals("")) {
            return false;
        }
        return true;
    }


    @FXML
    private boolean allCardInformation() {
        if (IMatDataHandler.getInstance().getCreditCard().getCardType().equals("") ||
                IMatDataHandler.getInstance().getCreditCard().getCardType().equals("") ||
                //IMatDataHandler.getInstance().getCreditCard().getValidMonth().equals(null) ||
                //IMatDataHandler.getInstance().getCreditCard().getValidYear().equals(null) ||
                IMatDataHandler.getInstance().getCreditCard().getCardNumber().equals("") ||
                IMatDataHandler.getInstance().getCreditCard().getHoldersName().equals("")) {
            return false;
        }
        return true;
    }

    @FXML
    private void goBack() {
        controller.changeMainTo("scenes/components/payChoice.fxml");
    }

    @FXML
    private void loadConfirmation() {
        if (!allUserInformation()) {
            controller.loadMyAccount();
            System.out.println("skicka till Mitt konto > Personuppgifter");
        } else if (!allCardInformation()) {
            text.setText("Lägg till dina kortuppgifter under Personuppgifter");
            //controller.loadMyAccount();
            System.out.println("skicka till Mitt konto > Kortuppgifter");
        } else
            controller.changeMainTo("scenes/components/confirmation.fxml");
        Order neworder = IMatDataHandler.getInstance().placeOrder();
        neworder.setDate(new Date());
        //neworder.setOrderNumber();

        String ordernumber = (IMatDataHandler.getInstance().getCustomer().getPhoneNumber());
        if (ordernumber == null) {
            ordernumber = "0";
            IMatDataHandler.getInstance().getCustomer().setPhoneNumber(ordernumber);

        } else {

            int temp = Integer.parseInt(ordernumber);
            temp = temp + 1;
            IMatDataHandler.getInstance().getCustomer().setPhoneNumber("" + temp);

        }
        neworder.setOrderNumber(Integer.parseInt(ordernumber));
        IMatDataHandler.getInstance().getShoppingCart().clear();

    }

    @FXML
    private ComboBox deliveryDay, deliveryTime;

    ObservableList<String> dayChoices = FXCollections.observableArrayList("Måndag", "Tisdag", "Onsdag", "Torsdag", "Fredag", "Lördag", "Söndag");
    ObservableList<String> timeChoices = FXCollections.observableArrayList("Förmiddag", "Eftermiddag");


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        deliveryDay.getSelectionModel().select("Välj dag:");
        deliveryDay.setItems(dayChoices);
        deliveryTime.getSelectionModel().select("Välj tid:");
        deliveryTime.setItems(timeChoices);
        //deliveryDay.getItems().addAll("Måndag", "Tisdag");
    }


}
