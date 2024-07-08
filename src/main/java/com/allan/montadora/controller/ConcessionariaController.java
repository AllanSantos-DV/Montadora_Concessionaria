package com.allan.montadora.controller;

import com.allan.montadora.enuns.FormaPagamento;
import com.allan.montadora.enuns.SituacaoCarro;
import com.allan.montadora.models.Carro;
import com.allan.montadora.models.CarroData;
import com.allan.montadora.services.ConcessionariaService;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.paint.Color;

import static com.allan.montadora.MainApp.stage;
import static com.allan.montadora.utils.TableUtils.configurarColuna;
import static com.allan.montadora.utils.TableUtils.setCorTableColumn;

public class ConcessionariaController extends BaseController {

    private final ConcessionariaService concessionariaService = new ConcessionariaService();
    @FXML
    private TableColumn<Carro, String> montadoraCarro, modeloCarro, fPagamentoCarro, situacaoCarro;
    @FXML
    private TableColumn<Carro, Color> corCarro;
    @FXML
    private TableColumn<Carro, Long> valorCarro;
    @FXML
    private Button btnVender;
    @FXML
    private ComboBox<String> formasPagamento;
    @FXML
    private Spinner<Integer> valorVeiculo;
    @FXML
    private TableView<Carro> tabelaVeiculos;

    public void initialize() {
        formasPagamento.getItems().addAll(FormaPagamento.getFormasPagamento());
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 1000000, 0);
        valorVeiculo.setValueFactory(valueFactory);
        valorVeiculo.valueProperty().addListener((obs, oldValue, newValue) -> {
            formasPagamento.setDisable(newValue == null || newValue <= 0);
            btnVender.setDisable(newValue == null || newValue <= 0);
        });
        tabelaVeiculos.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, event -> {
            Carro carro = tabelaVeiculos.getSelectionModel().getSelectedItem();
            valorVeiculo.setDisable(carro == null || !SituacaoCarro.DISPONIVEL.getSituacao().equals(carro.getSituacao()));
        });

        configurarColunas();
        tabelaVeiculos.setItems(CarroData.getCarros());
    }

    public void chamarMenu() {
        inicioTela.montarTela(stage);
    }

    private void configurarColunas() {
        configurarColuna(montadoraCarro, Carro::getMontadora);
        configurarColuna(modeloCarro, Carro::getModelo);
        configurarColuna(corCarro, Carro::getCor);
        configurarColuna(valorCarro, Carro::getValor);
        configurarColuna(fPagamentoCarro, Carro::getFormaPagamento);
        configurarColuna(situacaoCarro, Carro::getSituacao);
        setCorTableColumn(corCarro);
    }

    public void venderCarro() {
        Carro carro = tabelaVeiculos.getSelectionModel().getSelectedItem();
        carro.setFormaPagamento(formasPagamento.getValue());
        carro.setValor(valorVeiculo.getValue().longValue());
        carro.setSituacao(SituacaoCarro.VENDIDO.getSituacao());
        CarroData.updateCarro(carro);
    }


}
