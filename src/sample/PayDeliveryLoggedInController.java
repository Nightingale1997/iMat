package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;

import java.net.URL;
import java.util.Observable;
import java.util.ResourceBundle;

/**
 * Created by Elina Olsson on 2017-03-07.
 */
public class PayDeliveryLoggedInController {

    static Controller controller = Controller.getThisInstance();

    ObservableList<String> dayChoices = FXCollections.observableArrayList("Måndag", "Tisdag");

    //@FXML
    //private ChoiceBox deliveryDay, deliveryTime;

    @FXML
    private void loadConfirmation() {
        controller.changeMainTo("scenes/components/confirmation.fxml");
    }

    @FXML
    private ChoiceBox deliveryDay = new ChoiceBox();


    @FXML
    private void initialize(URL location, ResourceBundle resources) {
        deliveryDay.setItems(dayChoices);
        //deliveryDay.getItems().addAll("Måndag", "Tisdag");
    }
}
