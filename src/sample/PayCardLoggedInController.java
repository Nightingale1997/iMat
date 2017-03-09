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
    private Text error;


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
        if (deliveryDay.getValue().equals("Välj dag:") || deliveryTime.getValue().equals("Välj tid:")) {
            error.setText("Välj dag och tid för leverans.");

        } else if (!allUserInformation()) {
            controller.loadMyAccount();
            System.out.println("skicka till Mitt konto > Personuppgifter");
        } else if (!allCardInformation()) {
            error.setText("");
            text.setText("Lägg till dina kortuppgifter under Personuppgifter");
            //controller.loadMyAccount();
            System.out.println("skicka till Mitt konto > Kortuppgifter");
        } else if (allUserInformation()) {
            controller.changeMainTo("scenes/components/confirmation.fxml");

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
    }

    @FXML
    private ComboBox deliveryDay, deliveryTime;

    ObservableList<String> dayChoices = FXCollections.observableArrayList("Måndag", "Tisdag", "Onsdag", "Torsdag", "Fredag", "Lördag", "Söndag");
    ObservableList<String> timeChoices = FXCollections.observableArrayList("9-12", "12-15", "15-18");


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        deliveryDay.getSelectionModel().select("Välj dag:");
        deliveryDay.setItems(dayChoices);
        deliveryTime.getSelectionModel().select("Välj tid:");
        deliveryTime.setItems(timeChoices);
        //deliveryDay.getItems().addAll("Måndag", "Tisdag");
    }


}
