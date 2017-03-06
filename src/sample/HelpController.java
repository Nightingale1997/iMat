package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Created by Elina Olsson on 2017-03-06.
 */
public class HelpController {

    static Controller controller = Controller.getThisInstance();

    @FXML
    private Label helpHeadline, information, staffLabel;

    @FXML
    private ImageView staff, staffBubble;

    @FXML
    private void loadHelpOverview() {
        try {
            staff.setImage(new Image("sample/img/Personal.png"));
            staffBubble.setImage(new Image("sample/img/17015308_10154510925584385_860802045_o.png.png"));
            //staffLabel.setText(new Image("sample/img/17015308_10154510925584385_860802045_o.png.png"));
            information.setText(null);
            helpHeadline.setText("Översikt");
        } catch (Exception e) {

        }
    }

    @FXML
    private void loadHelpTutorial() {
        String headline = "Hur handlar jag?";
        String informationText = "Instruktioner till hur iMat fungerar.";
        loadHelpViews(headline, informationText);
    }

    @FXML
    private void loadHelpFAQ() {
        String headline = "Vanliga frågor";
        String informationText = "Vanliga frågor och svar.";
        loadHelpViews(headline, informationText);
    }

    @FXML
    private void loadHelpContact() {
        String headline = "Kontakta oss";
        String informationText = "Telefonnummer: 031-1234567";
        loadHelpViews(headline, informationText);
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

