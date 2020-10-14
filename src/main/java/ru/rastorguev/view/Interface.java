package ru.rastorguev.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

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

    public void switchOn(ActionEvent event) throws IOException {
        final ProcessBuilder pb = new ProcessBuilder();
        pb.redirectOutput(ProcessBuilder.Redirect.INHERIT);
        pb.redirectError(ProcessBuilder.Redirect.INHERIT);
        pb.command(CMD, C, CONFIGURATION_DATA);
        pb.start();
    }

    public void switchOff(ActionEvent event) throws IOException {
        final ProcessBuilder pb = new ProcessBuilder();
        pb.redirectOutput(ProcessBuilder.Redirect.INHERIT);
        pb.redirectError(ProcessBuilder.Redirect.INHERIT);
        pb.command(CMD, C, CONFIGURATION_DATA);
        pb.start();
    }

}
