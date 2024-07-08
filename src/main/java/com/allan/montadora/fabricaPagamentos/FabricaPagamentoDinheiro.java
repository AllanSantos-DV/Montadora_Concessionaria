package com.allan.montadora.fabricaPagamentos;

import com.allan.montadora.formasPagamento.PagamentoDinheiro;
import com.allan.montadora.interfaces.FabricaPagamento;
import com.allan.montadora.interfaces.Pagamento;

public class FabricaPagamentoDinheiro implements FabricaPagamento {

    @Override
    public Pagamento criarPagamento() {
        return new PagamentoDinheiro();
    }
}
