package com.allan.montadora.utils;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class PlacaMercosulGenerator {

    public static final Set<String> placasUtilizadas = new HashSet<>();
    private static final Random random = new Random();

    public static String gerarPlacaMercosul() {
        String placa;
        do {
            placa = gerarPlaca();
        } while (placasUtilizadas.contains(placa));

        placasUtilizadas.add(placa);
        return placa;
    }

    private static String gerarPlaca() {
        return gerarLetras(3) +
                gerarDigitos(1) +
                gerarLetras(1) +
                gerarDigitos(2);
    }

    private static String gerarLetras(int quantidade) {
        StringBuilder letras = new StringBuilder();
        for (int i = 0; i < quantidade; i++) {
            char letra = (char) (random.nextInt(26) + 'A');
            letras.append(letra);
        }
        return letras.toString();
    }

    private static String gerarDigitos(int quantidade) {
        StringBuilder digitos = new StringBuilder();
        for (int i = 0; i < quantidade; i++) {
            int digito = random.nextInt(10);
            digitos.append(digito);
        }
        return digitos.toString();
    }
}



