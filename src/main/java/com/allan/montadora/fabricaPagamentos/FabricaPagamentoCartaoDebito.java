package com.allan.montadora.fabricaPagamentos;

import com.allan.montadora.formasPagamento.PagamentoCartaoDebito;
import com.allan.montadora.interfaces.FabricaPagamento;
import com.allan.montadora.interfaces.Pagamento;

public class FabricaPagamentoCartaoDebito implements FabricaPagamento {

    @Override
    public Pagamento criarPagamento() {
        return new PagamentoCartaoDebito();
    }
}
