package com.allan.montadora.formasPagamento;

import com.allan.montadora.interfaces.Pagamento;
import com.allan.montadora.models.Carro;
import com.allan.montadora.models.CarroData;
import com.allan.montadora.services.ConcessionariaService;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ProgressIndicator;
import javafx.stage.Stage;

import java.util.Optional;
import java.util.function.Consumer;

import static com.allan.montadora.utils.AlertUtil.showAlert;

public class PagamentoDinheiro implements Pagamento {

    @Override
    public void realizarPagamento(Carro carro, ProgressIndicator progress, Consumer<Void> chamarTelaCallback) {
        CarroData.updateCarro(carro);
    }

    @Override
    public void montarTela(Stage stage) {
        Optional<ButtonType> result = showAlert(Alert.AlertType.CONFIRMATION, "Pagamento em dinheiro", "Confirmar Pagamento em dinheiro.");
        result.ifPresent(buttonType -> {
            if (buttonType == ButtonType.OK) {
                realizarPagamento(ConcessionariaService.getCarroUpdated(), null, null);
            }
        });
    }
}
