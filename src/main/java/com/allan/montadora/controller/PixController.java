package com.allan.montadora.controller;

import com.allan.montadora.formasPagamento.PagamentoPix;
import com.allan.montadora.utils.SingletonUtil;
import javafx.fxml.FXML;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextField;

import static com.allan.montadora.utils.FormaterValorBr.formatarValor;

public class PixController extends BaseController {

    private final PagamentoPix pagamentoPix = SingletonUtil.getInstance(PagamentoPix.class);
    @FXML
    private TextField valorCarro;
    @FXML
    private ProgressIndicator progress;

    public void initialize() {
        valorCarro.setText(formatarValor(getCarro().getValor()));
    }

    public void confirmarPix() {
        pagamentoPix.realizarPagamento(getCarro(), progress, (v) -> chamarTela(concessionariaTela));
    }

    public void cancelar() {
        chamarTela(concessionariaTela);
    }
}
