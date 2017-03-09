package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.chalmers.ait.dat215.project.Order;
import se.chalmers.ait.dat215.project.ShoppingItem;
import javafx.scene.control.ListView;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

/**
 * Created by elina on 2017-03-06.
 */
public class MyAccountHistoryController {

    static Controller controller = Controller.getThisInstance();

    /*@FXML
    private ListView historyList;
    */

    private List<Order> history = new ArrayList<>();

    @FXML
    private ListView historyList;


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
        controller.changeMainTo("scenes/components/myAccountCard.fxml");
    }

    @FXML
    private void loadMyAccountHistory() {
        controller.changeMainTo("scenes/components/myAccountHistory.fxml");
        //historyList.setItems(IMatDataHandler.getInstance().getOrders().toString());
    }

}
