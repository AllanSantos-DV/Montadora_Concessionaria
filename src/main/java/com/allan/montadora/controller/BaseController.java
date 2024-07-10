package com.allan.montadora.controller;

import com.allan.montadora.interfaces.TelaManager;
import com.allan.montadora.models.Carro;
import com.allan.montadora.services.ConcessionariaService;
import com.allan.montadora.services.InicioTela;
import com.allan.montadora.services.MontadoraService;
import com.allan.montadora.utils.SingletonUtil;
import javafx.application.Platform;
import lombok.extern.log4j.Log4j2;

import static com.allan.montadora.MainApp.stage;

@Log4j2
public abstract class BaseController {

    public final TelaManager inicioTela = SingletonUtil.getInstance(InicioTela.class);
    public final TelaManager montadoraTela = SingletonUtil.getInstance(MontadoraService.class);
    public final TelaManager concessionariaTela = SingletonUtil.getInstance(ConcessionariaService.class);

    public Long valorTotal;

    public Carro getCarro() {
        return ConcessionariaService.getCarroUpdated();
    }

    public void fecharApp() {
        Platform.exit();
        log.info("Aplicação encerrada.");
    }

    public void chamarMenu() {
        inicioTela.montarTela(stage);
    }

    public void chamarTela(TelaManager tela) {
        tela.montarTela(stage);
    }
}
