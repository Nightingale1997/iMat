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
        controller.currentSearch.addAll(IMatDataHandler.getInstance().getProducts(ProductCategory.BERRY));
        controller.currentSearch.addAll(IMatDataHandler.getInstance().getProducts(ProductCategory.CABBAGE));
        controller.currentSearch.addAll(IMatDataHandler.getInstance().getProducts(ProductCategory.CITRUS_FRUIT));
        controller.currentSearch.addAll(IMatDataHandler.getInstance().getProducts(ProductCategory.EXOTIC_FRUIT));
        controller.currentSearch.addAll(IMatDataHandler.getInstance().getProducts(ProductCategory.VEGETABLE_FRUIT));
        controller.currentSearch.addAll(IMatDataHandler.getInstance().getProducts(ProductCategory.MELONS));
        controller.currentSearch.addAll(IMatDataHandler.getInstance().getProducts(ProductCategory.ROOT_VEGETABLE));
        controller.currentSearch.addAll(IMatDataHandler.getInstance().getProducts(ProductCategory.FRUIT));
        controller.currentSearch.addAll(IMatDataHandler.getInstance().getProducts(ProductCategory.HERB));
        controller.addSearchHits();
    }

   @FXML
    private void findFridge() {
        controller.changeMainTo("scenes/components/searchResults.fxml");
        controller.currentSearch.clear();
        controller.currentSearch.addAll(IMatDataHandler.getInstance().getProducts(ProductCategory.DAIRIES));
        controller.currentSearch.addAll(IMatDataHandler.getInstance().getProducts(ProductCategory.COLD_DRINKS));
        controller.addSearchHits();
    }

    private void findDrygoods() {
        controller.changeMainTo("scenes/components/searchResults.fxml");
        controller.currentSearch.clear();
        controller.currentSearch.addAll(IMatDataHandler.getInstance().getProducts(ProductCategory.HOT_DRINKS));
        controller.currentSearch.addAll(IMatDataHandler.getInstance().getProducts(ProductCategory.POD));
        controller.currentSearch.addAll(IMatDataHandler.getInstance().getProducts(ProductCategory.FLOUR_SUGAR_SALT));
        controller.currentSearch.addAll(IMatDataHandler.getInstance().getProducts(ProductCategory.NUTS_AND_SEEDS));
        controller.currentSearch.addAll(IMatDataHandler.getInstance().getProducts(ProductCategory.PASTA));
        controller.currentSearch.addAll(IMatDataHandler.getInstance().getProducts(ProductCategory.POTATO_RICE));
        controller.addSearchHits();
    }

    private void findMeatFish() {
        controller.changeMainTo("scenes/components/searchResults.fxml");
        controller.currentSearch.clear();
        controller.currentSearch.addAll(IMatDataHandler.getInstance().getProducts(ProductCategory.MEAT));
        controller.currentSearch.addAll(IMatDataHandler.getInstance().getProducts(ProductCategory.FISH));
        controller.addSearchHits();
    }

    private void findSweetsBread() {
        controller.changeMainTo("scenes/components/searchResults.fxml");
        controller.currentSearch.clear();
        controller.currentSearch.addAll(IMatDataHandler.getInstance().getProducts(ProductCategory.SWEET));
        controller.currentSearch.addAll(IMatDataHandler.getInstance().getProducts(ProductCategory.BREAD));
        controller.addSearchHits();
    }


}
