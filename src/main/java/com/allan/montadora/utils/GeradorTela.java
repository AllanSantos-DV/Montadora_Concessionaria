package com.allan.montadora.utils;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;

@Log4j2
public class GeradorTela {

    public static void gerarTela(Stage stage, FXMLLoader caminhoFXML, int largura, int altura, String title) {
        try {
            stage.close();
            Scene scene = new Scene(caminhoFXML.load(), largura, altura);
            stage.setScene(scene);
            stage.setTitle(title);
            stage.setOnCloseRequest(e -> {
                Platform.exit();
                log.info("Aplicação encerrada.");
            });
            stage.show();
        } catch (IOException e) {
            log.error("Erro ao montar tela: ", e);
        }
    }
}
