package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.chalmers.ait.dat215.project.Order;

import java.net.URL;
import java.util.*;

/**
 * Created by Elina Olsson on 2017-03-07.
 */
public class PayDeliveryLoggedInController implements Initializable {


    static Controller controller = Controller.getThisInstance();
    //static PayChoiceController payChoiceController = PayChoiceController.getThisInstance();


    //@FXML
    //private ChoiceBox deliveryDay, deliveryTime;

    @FXML
    private ComboBox deliveryDay, deliveryTime;

    @FXML
    private Button sendOrder;

    @FXML
    private Label invoiceLabel;

    private List<String> newReciept = new ArrayList<>();

    ObservableList<String> dayChoices = FXCollections.observableArrayList("Måndag", "Tisdag", "Onsdag", "Torsdag", "Fredag", "Lördag", "Söndag");
    ObservableList<String> timeChoices = FXCollections.observableArrayList("Förmiddag", "Eftermiddag");


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
    private void goBack() {
        //payChoiceController.
    }

    @FXML
    private void loadConfirmation() {
        if (!allUserInformation()) {
            controller.loadMyAccount();
            //System.out.println("skicka till Mitt konto > Personuppgifter");
            //invoiceLabel.setText("Personuppgifter saknas!");
            //sendOrder.setText("Uppdatera personuppgifter");
        } else if (allUserInformation()) {
            controller.changeMainTo("scenes/components/confirmation.fxml");
        }
        Order neworder = IMatDataHandler.getInstance().placeOrder();
        neworder.setDate(new Date());
        //neworder.setOrderNumber();

        String ordernumber = (IMatDataHandler.getInstance().getCustomer().getPhoneNumber());
        if (ordernumber == "0") {
            ordernumber = "1";
            IMatDataHandler.getInstance().getCustomer().setPhoneNumber(ordernumber);

        } else {
            System.out.println("check" + ordernumber);
            int temp = Integer.parseInt(ordernumber);
            temp = temp + 1;
            IMatDataHandler.getInstance().getCustomer().setPhoneNumber("" + temp);

        }
        System.out.println("Ordernummer" + IMatDataHandler.getInstance().getCustomer().getPhoneNumber());
        neworder.setOrderNumber(Integer.parseInt(IMatDataHandler.getInstance().getCustomer().getPhoneNumber()));

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        deliveryDay.getSelectionModel().select("Välj dag:");
        deliveryDay.setItems(dayChoices);
        deliveryTime.getSelectionModel().select("Välj tid:");
        deliveryTime.setItems(timeChoices);
        //deliveryDay.getItems().addAll("Måndag", "Tisdag");
    }
}
