package com.allan.montadora.controller;

import com.allan.montadora.interfaces.TelaManager;
import javafx.application.Platform;
import lombok.extern.log4j.Log4j2;

import static com.allan.montadora.services.ConcessionariaService.getTelaConcessionaria;
import static com.allan.montadora.services.InicioTela.getTelaInicio;
import static com.allan.montadora.services.MontadoraService.getTelaMontadora;

@Log4j2
public abstract class BaseController {

    public final TelaManager inicioTela = getTelaInicio();
    public final TelaManager montadoraTela = getTelaMontadora();
    public final TelaManager concessionariaTela = getTelaConcessionaria();

    public void fecharApp() {
        Platform.exit();
        log.info("Aplicação encerrada.");
    }
}
