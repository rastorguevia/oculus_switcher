package ru.rastorguev.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.File;

import static ru.rastorguev.constant.Constant.*;

public final class Interface extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        stage.setTitle("Oculus Switcher");

        Parent mainScene = FXMLLoader.load(new File(MAIN_SCENE).toURL());
        stage.setScene(new Scene(mainScene, 800, 600));

        stage.getIcons().add(new Image(LOGO_YELLOW));

        stage.show();

    }

}
