package com.allan.montadora.controller;

import com.allan.montadora.formasPagamento.PagamentoCartaoDebito;
import com.allan.montadora.utils.SingletonUtil;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextField;

import static com.allan.montadora.utils.FormaterValorBr.formatarValor;

public class DebitoController extends BaseController {

    private final PagamentoCartaoDebito pagamentoCartaoDebito = SingletonUtil.getInstance(PagamentoCartaoDebito.class);
    @FXML
    private PasswordField senha;
    @FXML
    private TextField precoCarro;
    @FXML
    private ProgressIndicator progress;
    @FXML
    private Button btnPagar;

    public void initialize() {
        precoCarro.setText(formatarValor(getCarro().getValor()));
        senha.textProperty().addListener((obs, oldValue, newValue) -> btnPagar.setDisable(newValue == null || newValue.length() < 4));
    }

    public void realizarPagamento() {
        pagamentoCartaoDebito.realizarPagamento(getCarro(), progress, (v) -> chamarTela(concessionariaTela));
    }

    public void cancelar() {
        chamarTela(concessionariaTela);
    }
}
