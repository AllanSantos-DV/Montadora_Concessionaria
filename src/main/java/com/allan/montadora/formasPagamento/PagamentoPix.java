package com.allan.montadora.formasPagamento;

import com.allan.montadora.interfaces.Pagamento;

public class PagamentoPix implements Pagamento {

    @Override
    public void realizarPagamento() {
        System.out.println("Pagamento efetuado via PIX.");
    }
}

