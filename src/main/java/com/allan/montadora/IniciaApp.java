package com.allan.montadora;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class IniciaApp {
    public static void main(String[] args) {
        log.info("Iniciando aplicação...");
        MainApp.main(args);
    }
}
