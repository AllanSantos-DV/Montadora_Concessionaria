package com.allan.montadora.utils;

import com.allan.montadora.enuns.FormaPagamento;
import com.allan.montadora.fabricaPagamentos.FabricaPagamentoCartaoCredito;
import com.allan.montadora.fabricaPagamentos.FabricaPagamentoCartaoDebito;
import com.allan.montadora.fabricaPagamentos.FabricaPagamentoDinheiro;
import com.allan.montadora.fabricaPagamentos.FabricaPagamentoPix;
import com.allan.montadora.interfaces.FabricaPagamento;

public class FabricaPagamentos {

    public static FabricaPagamento getFabricaPagamento(FormaPagamento formaPagamento) {
        return switch (formaPagamento) {
            case DINHEIRO -> new FabricaPagamentoDinheiro();
            case CARTAO_CREDITO -> new FabricaPagamentoCartaoCredito();
            case CARTAO_DEBITO -> new FabricaPagamentoCartaoDebito();
            case PIX -> new FabricaPagamentoPix();
        };
    }
}
