package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import se.chalmers.ait.dat215.project.IMatDataHandler;

/**
 * Created by Elina Olsson on 2017-03-08.
 */
public class HomePageController {

    static Controller controller = Controller.getThisInstance();
    static HelpController helpController  = HelpController.getThisInstance();
    //static MyAccountController myAccountController = MyAccountController.getThisInstance();

    @FXML
    private Pane tutorialButton, shopButton;

    @FXML
    private Button registerInfo;

    @FXML
    private void loadMainPageCategories() {
        //controller = Controller.getThisInstance();
        try {
            Stage stage = (Stage) shopButton.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("scenes/sample2.fxml"));
            stage.setTitle("iMat - Handla Enkelt!");
            stage.setScene(new Scene(root, 1280, 720));
            stage.show();
            controller = Controller.getThisInstance();
            controller.loadMainPageCategories();
        } catch (Exception e) {

        }
        IMatDataHandler.getInstance().getCustomer().setPhoneNumber("0");
    }

    @FXML
    private void loadAccountInformation() {

        //controller = Controller.getThisInstance();
        try {
            Stage stage = (Stage) registerInfo.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("scenes/sample2.fxml"));
            stage.setTitle("iMat - Handla Enkelt!");
            stage.setScene(new Scene(root, 1280, 720));
            stage.show();
            controller = Controller.getThisInstance();
            //myAccountController.setAccountInfo(true);
            controller.loadMyAccount();
            //myAccountController = MyAccountController.getThisInstance();
            //myAccountController.loadMyAccountInformation();
        } catch (Exception e) {

        }
        IMatDataHandler.getInstance().getCustomer().setPhoneNumber("0");
    }

    @FXML
    private void loadRegistration() {

        try {
            Stage stage = (Stage) registerInfo.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("scenes/sample2.fxml"));
            stage.setTitle("iMat - Handla Enkelt!");
            stage.setScene(new Scene(root, 1280, 720));
            stage.show();
            controller = Controller.getThisInstance();
            //myAccountController.setAccountInfo(true);
            controller.loadRegistration();
            //myAccountController = MyAccountController.getThisInstance();
            //myAccountController.loadMyAccountInformation();
        } catch (Exception e) {

        }
    }

    /*@FXML
    private void loadRegisterOrLogin() {
        //controller = Controller.getThisInstance();
        try {
            Stage stage = (Stage) registerOrLogin.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("scenes/sample2.fxml"));
            stage.setTitle("iMat - Handla Enkelt!");
            stage.setScene(new Scene(root, 1280, 720));
            stage.show();
            controller = Controller.getThisInstance();
            controller.loadRegisterOrLogin();
        } catch (Exception e) {

        }
    }*/

    @FXML
    private void loadHelpOverview() {
        //controller = Controller.getThisInstance();
        try {
            Stage stage = (Stage) tutorialButton.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("scenes/sample2.fxml"));
            stage.setTitle("iMat - Handla Enkelt!");
            stage.setScene(new Scene(root, 1280, 720));
            stage.show();
            controller = Controller.getThisInstance();
            controller.setTutorial(true);
            controller.loadHelpOverview();
        } catch (Exception e) {

        }
        IMatDataHandler.getInstance().getCustomer().setPhoneNumber("0");
    }

}
