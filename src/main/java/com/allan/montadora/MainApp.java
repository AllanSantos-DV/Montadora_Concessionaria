package com.allan.montadora;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

import static com.allan.montadora.utils.GeradorTela.gerarTela;

public class MainApp extends Application {
    public static Stage stage;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) {
        MainApp.stage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("InicioApp.fxml"));
        gerarTela(stage, fxmlLoader, 400, 250, "Allan!");
    }
}