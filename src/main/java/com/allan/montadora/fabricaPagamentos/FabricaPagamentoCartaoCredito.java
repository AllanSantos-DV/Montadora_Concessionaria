package com.allan.montadora.fabricaPagamentos;

import com.allan.montadora.formasPagamento.PagamentoCartaoCredito;
import com.allan.montadora.interfaces.FabricaPagamento;
import com.allan.montadora.interfaces.Pagamento;

public class FabricaPagamentoCartaoCredito implements FabricaPagamento {

    @Override
    public Pagamento criarPagamento() {
        return new PagamentoCartaoCredito();
    }
}
