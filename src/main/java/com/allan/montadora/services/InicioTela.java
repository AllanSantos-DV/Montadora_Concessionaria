package com.allan.montadora.services;

import com.allan.montadora.MainApp;
import com.allan.montadora.interfaces.TelaManager;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

import static com.allan.montadora.utils.GeradorTela.gerarTela;

public class InicioTela implements TelaManager {

    private InicioTela() {}

    @Override
    public void montarTela(Stage stage) {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("InicioApp.fxml"));
        gerarTela(stage, fxmlLoader, 400, 250, "Allan!");
    }

}
