package com.allan.montadora.controller;

import com.allan.montadora.formasPagamento.PagamentoCartaoCredito;
import com.allan.montadora.formasPagamento.PagamentoCartaoDebito;
import com.allan.montadora.formasPagamento.PagamentoPix;
import com.allan.montadora.interfaces.TelaManager;
import com.allan.montadora.services.ConcessionariaService;
import com.allan.montadora.services.InicioTela;
import com.allan.montadora.services.MontadoraService;
import com.allan.montadora.utils.SingletonUtil;
import javafx.application.Platform;
import lombok.extern.log4j.Log4j2;

@Log4j2
public abstract class BaseController {

    public final TelaManager inicioTela = SingletonUtil.getInstance(InicioTela.class);
    public final TelaManager montadoraTela = SingletonUtil.getInstance(MontadoraService.class);
    public final TelaManager concessionariaTela = SingletonUtil.getInstance(ConcessionariaService.class);
    public final TelaManager creditoTela = SingletonUtil.getInstance(PagamentoCartaoCredito.class);
    public final TelaManager debitoTela = SingletonUtil.getInstance(PagamentoCartaoDebito.class);
    public final TelaManager pixTela = SingletonUtil.getInstance(PagamentoPix.class);

    public void fecharApp() {
        Platform.exit();
        log.info("Aplicação encerrada.");
    }
}
