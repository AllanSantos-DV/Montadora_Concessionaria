package com.allan.montadora.controller;

import com.allan.montadora.formasPagamento.PagamentoCartaoCredito;
import com.allan.montadora.utils.SingletonUtil;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class CreditoController extends BaseController {

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

    private final PagamentoCartaoCredito pagamentoCartaoCredito = SingletonUtil.getInstance(PagamentoCartaoCredito.class);

    public void realizarPagamento() {

    }

    public void cancelar() {

    }
}
