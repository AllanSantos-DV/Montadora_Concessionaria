package com.allan.montadora.formasPagamento;

import com.allan.montadora.MainApp;
import com.allan.montadora.interfaces.Pagamento;
import com.allan.montadora.interfaces.TelaManager;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

import static com.allan.montadora.utils.GeradorTela.gerarTela;

public class PagamentoCartaoCredito implements Pagamento, TelaManager {

    private PagamentoCartaoCredito() {}

    @Override
    public void realizarPagamento() {

    }

    @Override
    public void montarTela(Stage stage) {
        FXMLLoader caminhoFXML = new FXMLLoader(MainApp.class.getResource("TelaCredito.fxml"));
        gerarTela(stage, caminhoFXML, 470, 440, "Pagamento Cartão de Crédito");
    }
}
