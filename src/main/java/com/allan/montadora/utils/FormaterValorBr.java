package com.allan.montadora.utils;

import java.text.NumberFormat;
import java.util.Locale;

public class FormaterValorBr {

    public static String formatarValor(Long valor) {
        NumberFormat formatador = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        return formatador.format(valor);
    }
}
