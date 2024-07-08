package com.allan.montadora.fabricaPagamentos;

import com.allan.montadora.formasPagamento.PagamentoPix;
import com.allan.montadora.interfaces.FabricaPagamento;
import com.allan.montadora.interfaces.Pagamento;

public class FabricaPagamentoPix implements FabricaPagamento {

    @Override
    public Pagamento criarPagamento() {
        return new PagamentoPix();
    }
}

