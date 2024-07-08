package com.allan.montadora.controller;

import static com.allan.montadora.MainApp.stage;

public class InicioController extends BaseController {

    public void chamarMontadora() {
        montadoraTela.montarTela(stage);
    }

    public void chamarConcessionaria() {
        concessionariaTela.montarTela(stage);
    }

}

