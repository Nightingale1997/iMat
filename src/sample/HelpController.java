package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Elina Olsson on 2017-03-06.
 */
public class HelpController implements Initializable {

    public static HelpController getThisInstance() {
        if (thisInstance == null) {
            thisInstance = new HelpController();
        }
        return thisInstance;
    }

    static HelpController thisInstance;

    static Controller controller;

    @FXML
    private Label helpHeadline, information, staffLabel, helpTutorial, helpFAQ, helpContact, helpOverview;

    @FXML
    private ImageView staff, staffBubble;

    /*private HelpController(){

    }*/

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        controller = Controller.getThisInstance();
        if(controller.getTutorial()){
            loadHelpTutorial();
        }
        else{
            System.out.println("else");
        }
    }


    @FXML
    public void loadHelpOverview() {

        try {
            staff.setImage(new Image("sample/img/Personal.png"));
            staffBubble.setImage(new Image("sample/img/17015308_10154510925584385_860802045_o.png"));
            staffLabel.setText("Vad kan jag hjälpa dig med?\n" +
                    "Välj bland kategorierna i listan till vänster.\n");
            information.setText(null);
            helpHeadline.setText(helpOverview.getText());

        } catch (Exception e) {
            //Vet inte riktigt vad det ska stå här
        }

    }

    @FXML
    public void loadHelpTutorial() {
        //System.out.println("hej");
        String informationText = "Instruktioner till hur iMat fungerar.";
        loadHelpViews(informationText, helpTutorial.getText());
    }

    @FXML
    private void loadHelpFAQ() {
        String headline = "Vanliga frågor";
        String informationText = "Vanliga frågor och svar.";
        loadHelpViews(informationText, helpFAQ.getText());
    }

    @FXML
    private void loadHelpContact() {
        String headline = "Kontakta oss";
        String informationText = "Telefonnummer: 031-1234567";
        loadHelpViews(informationText, helpContact.getText());
    }

    @FXML
    private void loadHelpViews(String informationText, String headline) {
        staff.setImage(null);
        staffBubble.setImage(null);
        staffLabel.setText(null);
        information.setText(informationText);
        helpHeadline.setText(headline);
    }


}

