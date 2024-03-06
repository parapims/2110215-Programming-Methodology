package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pane.RootPane;

public class Main extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) {
        Scene newScene = new Scene(RootPane.getRootPane(),430,932);
        stage.setTitle("Let's Read");
        stage.setResizable(false);
        stage.setScene(newScene);
        stage.show();
    }
}