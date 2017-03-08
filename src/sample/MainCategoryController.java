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
        controller.changeMainTo("scenes/components/searchResults.fxml");
        controller.currentSearch.clear();
        //controller.currentSearch.addAll(IMatDataHandler.getInstance().getProducts(ProductCategory.CABBAGE));
       // controller.currentSearch.addAll(IMatDataHandler.getInstance().getProducts(ProductCategory.CABBAGE));
       // controller.currentSearch.addAll(IMatDataHandler.getInstance().getProducts(ProductCategory.CABBAGE));
        controller.currentSearch.addAll(IMatDataHandler.getInstance().getProducts(ProductCategory.CABBAGE));
        controller.addSearchHits();
    }
}
