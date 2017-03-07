package sample;

import javafx.fxml.FXML;

/**
 * Created by elina on 2017-03-06.
 */
public class MyAccountCardController {

    static Controller controller = Controller.getThisInstance();

    @FXML
    private void loadMyAccountWelcome() {
        /*String informationText = "Vanliga frågor och svar.";
        loadMyAccountViews(informationText, myAccountCard.getText());*/
        controller.changeMainTo("scenes/components/myAccountWelcome.fxml");
    }

    @FXML
    private void loadMyAccountInformation() {
        /*String informationText = "Vanliga frågor och svar.";
        loadMyAccountViews(informationText, myAccountCard.getText());*/
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

}
