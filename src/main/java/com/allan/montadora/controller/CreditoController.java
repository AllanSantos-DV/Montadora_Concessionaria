package com.allan.montadora.controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class CreditoController {

    @FXML
    private Button btnPagar, btnCancel;
    @FXML
    private PasswordField senha;
    @FXML
    private ComboBox<Integer> cmbParcelas;
    @FXML
    private TextField precoCarro, precoFinalCarro;
    @FXML
    private ProgressIndicator progress;

    public void realizarPagamento() {

    }

    public void cancelar() {

    }
}
