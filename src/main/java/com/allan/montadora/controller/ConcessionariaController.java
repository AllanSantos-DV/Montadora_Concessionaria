package com.allan.montadora.controller;

import com.allan.montadora.enuns.FormaPagamento;
import com.allan.montadora.enuns.SituacaoCarro;
import com.allan.montadora.models.Carro;
import com.allan.montadora.models.CarroData;
import com.allan.montadora.services.ConcessionariaService;
import com.allan.montadora.utils.SingletonUtil;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import lombok.extern.log4j.Log4j2;

import java.util.Objects;

import static com.allan.montadora.MainApp.stage;
import static com.allan.montadora.utils.TableUtils.configurarColuna;
import static com.allan.montadora.utils.TableUtils.setCorTableColumn;

@Log4j2
public class ConcessionariaController extends BaseController {

    private final ConcessionariaService concessionariaService = SingletonUtil.getInstance(ConcessionariaService.class);
    @FXML
    private TableColumn<Carro, String> placaCarro;
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
        concessionariaService.configSpinner(valorVeiculo);
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
        configurarColuna(placaCarro, Carro::getPlacaMercosul);
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
        if (carro != null) {
            concessionariaService.vendaCarro(
                    carro.getPlacaMercosul(),
                    Objects.requireNonNull(FormaPagamento.getFormaPagamento(formasPagamento.getValue())),
                    valorVeiculo.getValue());
        }
        concessionariaService.configSpinner(valorVeiculo);
        tabelaVeiculos.refresh();
    }

}
