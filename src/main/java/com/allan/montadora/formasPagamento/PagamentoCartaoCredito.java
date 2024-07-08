package com.allan.montadora.formasPagamento;

import com.allan.montadora.interfaces.Pagamento;
import javafx.scene.control.Alert;

public class PagamentoCartaoCredito implements Pagamento {

    @Override
    public void realizarPagamento() {

    }

    private void alertPagamento() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Pagamento");
        alert.setHeaderText("Pagamento com cartão de crédito");

    }
}
