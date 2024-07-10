package com.allan.montadora.controller;

import com.allan.montadora.formasPagamento.PagamentoCartaoCredito;
import com.allan.montadora.models.Carro;
import com.allan.montadora.utils.SingletonUtil;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.stream.IntStream;

import static com.allan.montadora.utils.FormaterValorBr.formatarValor;

public class CreditoController extends BaseController {

    @FXML
    private Button btnPagar;
    @FXML
    private PasswordField senha;
    @FXML
    private ComboBox<Integer> cmbParcelas;
    @FXML
    private TextField precoCarro, precoFinalCarro;
    @FXML
    private ProgressIndicator progress;

    private final PagamentoCartaoCredito pagamentoCartaoCredito = SingletonUtil.getInstance(PagamentoCartaoCredito.class);

    public void initialize() {
        precoCarro.setText(formatarValor(getCarro().getValor()));
        cmbParcelas.getItems().addAll(IntStream.range(1, 49).boxed().toList());
        cmbParcelas.getSelectionModel().select(0);
        senha.textProperty().addListener((obs, oldValue, newValue) -> btnPagar.setDisable(newValue == null || newValue.length() < 4));
        valorFinal();
    }

    public void realizarPagamentoCredito() {
        Carro carro = getCarro();
        carro.setValor(valorTotal);
        pagamentoCartaoCredito.realizarPagamento(carro, progress, (v) -> chamarTela(concessionariaTela));
    }

    public void cancelar() {
        chamarTela(concessionariaTela);
    }

    public void valorFinal() {
        valorTotal = pagamentoCartaoCredito.configParcelas(cmbParcelas.getValue(), getCarro().getValor());
        precoFinalCarro.setText(formatarValor(valorTotal));
    }
}