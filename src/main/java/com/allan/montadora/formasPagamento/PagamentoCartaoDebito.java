package com.allan.montadora.formasPagamento;

import com.allan.montadora.interfaces.Pagamento;

public class PagamentoCartaoDebito implements Pagamento {

    @Override
    public void realizarPagamento() {
        System.out.println("Pagamento efetuado com cartão de débito.");
    }
}
