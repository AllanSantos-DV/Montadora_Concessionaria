package com.allan.montadora.formasPagamento;

import com.allan.montadora.MainApp;
import com.allan.montadora.interfaces.Pagamento;
import com.allan.montadora.interfaces.TelaManager;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

import static com.allan.montadora.utils.GeradorTela.gerarTela;

public class PagamentoCartaoDebito implements Pagamento, TelaManager {

    private PagamentoCartaoDebito() {}

    @Override
    public void realizarPagamento() {
        System.out.println("Pagamento efetuado com cartão de débito.");
    }

    @Override
    public void montarTela(Stage stage) {
        FXMLLoader caminhoFXML = new FXMLLoader(MainApp.class.getResource("TelaDebito.fxml"));
        gerarTela(stage, caminhoFXML, 455, 455, "Pagamento Cartão de Débito");
    }
}
