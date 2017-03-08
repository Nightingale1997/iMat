package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.text.*;
import javafx.stage.WindowEvent;
import se.chalmers.ait.dat215.project.IMatDataHandler;

import java.io.File;

public class Main extends Application {

    Controller controller;

    @Override
    public void start(Stage primaryStage) throws Exception {

        // load the  font.
        Font.loadFont(getClass().getResourceAsStream("css/OpenSans.ttf"), 14);


        File file = new File("firstrun.txt");
        boolean firstRun = false;
        if (!file.exists()) {
            firstRun = true;
            //file.createNewFile();

            //Parent root = FXMLLoader.load(getClass().getResource("scenes/payinfo.fxml"));
            Parent root = FXMLLoader.load(getClass().getResource("scenes/sample3.fxml"));
            primaryStage.setTitle("iMat - Handla Enkelt!");
            primaryStage.setScene(new Scene(root, 1280, 720));
            primaryStage.show();
            //primaryStage.setFullScreen(true);
        } else {
            //Parent root = FXMLLoader.load(getClass().getResource("scenes/payinfo.fxml"));
            Parent root = FXMLLoader.load(getClass().getResource("scenes/sample2.fxml"));
            controller = Controller.getThisInstance();
            controller.changeMainTo("scenes/components/mainPageCategories.fxml");
            primaryStage.setTitle("iMat - Handla Enkelt!");
            primaryStage.setScene(new Scene(root, 1280, 720));
            primaryStage.show();
            //primaryStage.setFullScreen(true);
        }

        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                IMatDataHandler.getInstance().shutDown();
            }
        });
    }



    public static void main(String[] args) {
        launch(args);
    }
}
