package com.allan.montadora.formasPagamento;

import com.allan.montadora.interfaces.Pagamento;
import javafx.scene.control.Alert;

import static com.allan.montadora.utils.AlertUtil.showAlert;

public class PagamentoDinheiro implements Pagamento {

    @Override
    public void realizarPagamento() {
        showAlert(Alert.AlertType.INFORMATION, "Pagamento em dinheiro", "Pagamento efetuado em dinheiro.");
    }
}
