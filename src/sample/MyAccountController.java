package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.io.IOException;

/**
 * Created by elina on 2017-03-06.
 */
public class MyAccountController {

    static Controller controller = Controller.getThisInstance();

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
    private void loadMyAccountInformation() {
        /*String informationText = "Instruktioner till hur iMat fungerar.";
        loadMyAccountViews(informationText, myAccountInformation.getText());*/
        controller.changeMainTo("scenes/components/myAccountInformation.fxml");
    }

    @FXML
    private void loadMyAccountCard() {
        /*String informationText = "Vanliga frågor och svar.";
        loadMyAccountViews(informationText, myAccountCard.getText());*/
        controller.changeMainTo("scenes/components/myAccountCard.fxml");
    }

    @FXML
    private void loadMyAccountHistory() {
        /*String informationText = "Telefonnummer: 031-1234567";
        loadMyAccountViews(informationText, myAccountHistory.getText());*/
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
