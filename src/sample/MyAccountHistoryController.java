package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.chalmers.ait.dat215.project.Order;
import se.chalmers.ait.dat215.project.ShoppingItem;

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
    private Button historyAddToCart;

    @FXML
    private ListView historyReciept2;

    @FXML
    private ListView historyReciept1;

    @FXML
    private ListView historyReciept;

    @FXML
    private Label historyLabel;






    @FXML
    private void loadMyAccountWelcome() {
        controller.changeMainTo("scenes/components/myAccountWelcome.fxml");
    }

    @FXML
    public void loadMyAccountInformation() {
        try {
            Pane pane = FXMLLoader.load(getClass().getResource("scenes/components/myAccountInformation.fxml"));
            Pane childPane = (Pane) pane.getChildren().get(4);
            TextField email = (TextField) childPane.getChildren().get(3);
            email.textProperty().set(IMatDataHandler.getInstance().getCustomer().getEmail());
            TextField phoneNumber = (TextField) childPane.getChildren().get(5);
            phoneNumber.textProperty().set(IMatDataHandler.getInstance().getCustomer().getMobilePhoneNumber());
            TextField city = (TextField) childPane.getChildren().get(7);
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

    Order temporder = new Order();


    @FXML
    private void showHistory() {
        ObservableList<Text> orderlist = FXCollections.observableArrayList();
        for (Order o : IMatDataHandler.getInstance().getOrders()) {

            String shortDate = o.getDate().toString().substring(4,19);
            Text historytext = new Text("Order Nr. " + o.getOrderNumber() + " - " + shortDate);
            historytext.setFont(Font.font("OpenSans", FontWeight.NORMAL, 15));
            historytext.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    System.out.println("Ta Bort");

                    ObservableList<String> names = FXCollections.observableArrayList();
                    ObservableList<Integer> quantities = FXCollections.observableArrayList();
                    ObservableList<Double> prices = FXCollections.observableArrayList();

                    for(ShoppingItem si3 : o.getItems()){
                        temporder = o;
                        double quantity = si3.getAmount();
                        double price = si3.getProduct().getPrice()*si3.getAmount();
                        price = Math.round(price * 100.0) / 100.0;
                        String name = si3.getProduct().getName();

                        names.add(name);
                        quantities.add((int) quantity);
                        prices.add(price);
                    }

                    historyReciept.setItems(names);
                    historyReciept1.setItems(quantities);
                    historyReciept2.setItems(prices);
                    historyLabel.setText("");

                    if(names.size() == 0){
                        historyAddToCart.setDisable(true);
                    }
                    else{
                        historyAddToCart.setDisable(false);
                    }




                }
            });
            orderlist.add(historytext);

        }
        historyList.setItems(orderlist);
    }

    @FXML
    private void addhistory(){
    controller.shoppingCart.clear();

        for(ShoppingItem si : temporder.getItems()){
            controller.shoppingCart.addItem(si);
            controller.updateCartView();
        }

/*
        for(ShoppingItem si : temporder.getItems()){
            double amount = si.getAmount();
            boolean founditem = false;
            for (ShoppingItem si2 : controller.shoppingCart.getItems()) {
                System.out.println("Hej");
                if (si.getProduct().equals(si2.getProduct())) {
                    si2.setAmount(si2.getAmount() + amount);
                    si.setAmount(si.getAmount()/2);
                    founditem = true;
                }
            }
            if (!founditem) {
                Controller.shoppingCart.addItem(si);
            }

        }
        Controller.getThisInstance().updateCartView();
*/
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
    private void loadMyAccountHistory() {
        controller.changeMainTo("scenes/components/myAccountHistory.fxml");
        //historyList.setItems(IMatDataHandler.getInstance().getOrders().toString());
    }

}
