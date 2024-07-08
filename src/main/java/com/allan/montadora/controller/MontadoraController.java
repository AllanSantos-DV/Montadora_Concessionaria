package com.allan.montadora.controller;

import com.allan.montadora.enuns.Montadora;
import com.allan.montadora.services.MontadoraService;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.paint.Color;

import java.util.Arrays;

import static com.allan.montadora.MainApp.stage;

public class MontadoraController extends BaseController {

    private final String cmbMontadora = "Selecione a montadora: ";
    private final String cmbModelo = "Selecione o modelo: ";
    private final MontadoraService montadoraService = new MontadoraService();
    @FXML
    private ProgressBar progressBar;
    @FXML
    private Button btnGerar;
    @FXML
    private Spinner<Integer> qtdCarros;
    @FXML
    private ComboBox<String> comboBoxMontadoras, comboBoxModelos;
    @FXML
    private ColorPicker selectCores;

    public void initialize() {
        comboBoxMontadoras.setPromptText(cmbMontadora);
        comboBoxModelos.setPromptText(cmbModelo);
        selectCores.setValue(Color.TRANSPARENT);
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 0);
        qtdCarros.setValueFactory(valueFactory);
        qtdCarros.valueProperty().addListener((obs, oldValue, newValue) -> btnGerar.setDisable(newValue == null || newValue <= 0));
        comboBoxMontadoras.getItems().addAll(Montadora.getMontadoras());
    }

    public void chamarMenu() {
        inicioTela.montarTela(stage);
    }

    public void getMontadora() {
        montadoraService.getMontadora(comboBoxMontadoras, comboBoxModelos);
    }

    public void getModelo() {
        montadoraService.getModelo(comboBoxModelos, selectCores);
    }

    public void getCor() {
        montadoraService.getCor(selectCores, qtdCarros);
    }

    public void gerarCarros() {
        montadoraService.gerarCarros(qtdCarros, progressBar);
        limparCampos();
    }

    private void limparCampos() {
        Arrays.asList(comboBoxMontadoras, comboBoxModelos).forEach(comboBox -> comboBox.getSelectionModel().clearSelection());
        selectCores.setValue(Color.TRANSPARENT);
        qtdCarros.getValueFactory().setValue(0);
        qtdCarros.setDisable(true);

        Platform.runLater(() -> {
            comboBoxMontadoras.setPromptText("");
            comboBoxMontadoras.setPromptText(cmbMontadora);
            comboBoxModelos.setPromptText("");
            comboBoxModelos.setPromptText(cmbModelo);
        });
    }

}