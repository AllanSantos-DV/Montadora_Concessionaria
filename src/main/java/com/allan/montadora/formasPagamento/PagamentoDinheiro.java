package com.allan.montadora.formasPagamento;

import com.allan.montadora.interfaces.Pagamento;

public class PagamentoDinheiro implements Pagamento {

    @Override
    public void realizarPagamento() {
        System.out.println("Pagamento efetuado em dinheiro.");
    }
}
