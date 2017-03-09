package com.alex.javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public final class FirstApplication extends Application {
    @Override
    public final void start(Stage stage) throws Exception {
        Label message1 = new Label("Hello world!");
        message1.setFont(new Font(60));

        Label message2 = new Label("Hello world!");
        message2.setFont(new Font(60));

        final VBox vBox = new VBox(message1, message2);

        stage.setScene(new Scene(vBox));
        stage.setTitle("Hello");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
