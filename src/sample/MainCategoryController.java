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
        Controller.currentSearch.clear();
        Controller.currentSearch.addAll(IMatDataHandler.getInstance().getProducts(ProductCategory.BERRY));
        Controller.currentSearch.addAll(IMatDataHandler.getInstance().getProducts(ProductCategory.CABBAGE));
        Controller.currentSearch.addAll(IMatDataHandler.getInstance().getProducts(ProductCategory.CITRUS_FRUIT));
        Controller.currentSearch.addAll(IMatDataHandler.getInstance().getProducts(ProductCategory.EXOTIC_FRUIT));
        Controller.currentSearch.addAll(IMatDataHandler.getInstance().getProducts(ProductCategory.VEGETABLE_FRUIT));
        Controller.currentSearch.addAll(IMatDataHandler.getInstance().getProducts(ProductCategory.MELONS));
        Controller.currentSearch.addAll(IMatDataHandler.getInstance().getProducts(ProductCategory.ROOT_VEGETABLE));
        Controller.currentSearch.addAll(IMatDataHandler.getInstance().getProducts(ProductCategory.FRUIT));
        Controller.currentSearch.addAll(IMatDataHandler.getInstance().getProducts(ProductCategory.HERB));
        controller.addSearchHits();
    }

   @FXML
    private void findFridge() {
        controller.changeMainTo("scenes/components/searchResults.fxml");
        Controller.currentSearch.clear();
        Controller.currentSearch.addAll(IMatDataHandler.getInstance().getProducts(ProductCategory.DAIRIES));
        Controller.currentSearch.addAll(IMatDataHandler.getInstance().getProducts(ProductCategory.COLD_DRINKS));
        controller.addSearchHits();
    }

    @FXML
    private void findDrygoods() {
        controller.changeMainTo("scenes/components/searchResults.fxml");
        Controller.currentSearch.clear();
        Controller.currentSearch.addAll(IMatDataHandler.getInstance().getProducts(ProductCategory.HOT_DRINKS));
        Controller.currentSearch.addAll(IMatDataHandler.getInstance().getProducts(ProductCategory.POD));
        Controller.currentSearch.addAll(IMatDataHandler.getInstance().getProducts(ProductCategory.FLOUR_SUGAR_SALT));
        Controller.currentSearch.addAll(IMatDataHandler.getInstance().getProducts(ProductCategory.NUTS_AND_SEEDS));
        Controller.currentSearch.addAll(IMatDataHandler.getInstance().getProducts(ProductCategory.PASTA));
        Controller.currentSearch.addAll(IMatDataHandler.getInstance().getProducts(ProductCategory.POTATO_RICE));
        controller.addSearchHits();
    }

    @FXML
    private void findMeatFish() {
        controller.changeMainTo("scenes/components/searchResults.fxml");
        Controller.currentSearch.clear();
        Controller.currentSearch.addAll(IMatDataHandler.getInstance().getProducts(ProductCategory.MEAT));
        Controller.currentSearch.addAll(IMatDataHandler.getInstance().getProducts(ProductCategory.FISH));
        controller.addSearchHits();
    }

    @FXML
    private void findSweetsBread() {
        controller.changeMainTo("scenes/components/searchResults.fxml");
        Controller.currentSearch.clear();
        Controller.currentSearch.addAll(IMatDataHandler.getInstance().getProducts(ProductCategory.SWEET));
        Controller.currentSearch.addAll(IMatDataHandler.getInstance().getProducts(ProductCategory.BREAD));
        controller.addSearchHits();
    }


}
