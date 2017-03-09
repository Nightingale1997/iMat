package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.chalmers.ait.dat215.project.ProductCategory;

/**
 * Created by PiaLocal on 2017-03-08.
 */
public class MainCategoryController {
    static Controller controller = Controller.getThisInstance();

    @FXML
    private void findFruitGreens() {
        controller.findFruitGreens();
    }

   @FXML
    private void findFridge() {
        controller.findFridge();
    }

    @FXML
    private void findDrygoods() {
        controller.findDrygoods();
    }

    @FXML
    private void findMeatFish() {
        controller.findMeatFish();
    }

    @FXML
    private void findSweetsBread() {
        controller.findSweetsBread();
    }


}
