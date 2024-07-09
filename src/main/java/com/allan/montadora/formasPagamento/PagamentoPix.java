package com.allan.montadora.formasPagamento;

import com.allan.montadora.MainApp;
import com.allan.montadora.interfaces.Pagamento;
import com.allan.montadora.interfaces.TelaManager;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

import static com.allan.montadora.utils.GeradorTela.gerarTela;

public class PagamentoPix implements Pagamento, TelaManager {

    private PagamentoPix() {}

    @Override
    public void realizarPagamento() {
        System.out.println("Pagamento efetuado via PIX.");
    }

    @Override
    public void montarTela(Stage stage) {
        FXMLLoader caminhoFXML = new FXMLLoader(MainApp.class.getResource("TelaPix.fxml"));
        gerarTela(stage, caminhoFXML, 470, 445, "Pagamento PIX");
    }
}

