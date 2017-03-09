package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import se.chalmers.ait.dat215.project.IMatDataHandler;

import java.io.IOException;

/**
 * Created by elina on 2017-03-06.
 */
public class MyAccountController {

    public MyAccountController() {
        loadMyAccountInformation();
    }

    static Controller controller = Controller.getThisInstance();

    static MyAccountInformationController myAccountInformationController = MyAccountInformationController.getThisInstance();

    /*public static MyAccountController getThisInstance() {
        return thisInstance;
    }

    static MyAccountController thisInstance;
    public boolean getAccountInfo() {
        return accountInfo;
    }
    public void setAccountInfo(boolean tutorial) {
        this.accountInfo = accountInfo;
    }
    private boolean accountInfo;*/


    @FXML
    private ImageView staff, staffBubble;

    @FXML
    private Label myAccountWelcome, myAccountInformation, myAccountCard, myAccountHistory, staffLabel, informationText, myAccountHeadline;

    @FXML
    private Pane subPane, informationPane;

    /*
    Försökte ladda in nya vyer, men fick det inte att funka så testar att ha en standardvy och ladda om bilder och rubriker i metoderna nedanför i stället.

    @FXML
    private void loadMyAccountWelcome() {
        controller.changeMainTo("sample/scenes/components/myAccountWelcome");
    }

    @FXML
    private void loadMyAccountInformation() {
        controller.changeMainTo("sample/scenes/components/myAccountInformation");
    }

    @FXML
    private void loadMyAccountCard() {
        controller.changeMainTo("sample/scenes/components/myAccountCard");
    }

    @FXML
    private void loadMyAccountHistory() {
        controller.changeMainTo("sample/scenes/components/myAccountHistory");
    }*/


    @FXML
    private void loadMyAccountWelcome() {
        try {
            staff.setImage(new Image("sample/img/Personal.png"));
            staffBubble.setImage(new Image("sample/img/17015308_10154510925584385_860802045_o.png"));
            staffLabel.setText("Välkommen till ditt konto! Här kan du ändra dina kontouppgifter och se tidigare inköp.");
            myAccountHeadline.setText(myAccountWelcome.getText());
        } catch (Exception e) {
            //Vet inte riktigt vad det ska stå här
        }
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
    }

    @FXML
    private void loadMyAccountViews(String information, String headline) {
        staff.setImage(null);
        staffBubble.setImage(null);
        staffLabel.setText(null);
        informationText.setText(null);
        myAccountHeadline.setText(headline);
    }


}
