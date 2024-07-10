package com.allan.montadora.formasPagamento;

import com.allan.montadora.MainApp;
import com.allan.montadora.interfaces.Pagamento;
import com.allan.montadora.models.Carro;
import com.allan.montadora.models.CarroData;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ProgressIndicator;
import javafx.stage.Stage;
import lombok.Setter;

import java.util.function.Consumer;

import static com.allan.montadora.utils.GeradorTela.gerarTela;
import static com.allan.montadora.utils.TimeProgressUtil.configPagamento;

@Setter
public class PagamentoCartaoDebito implements Pagamento {

    private PagamentoCartaoDebito() {}

    @Override
    public void realizarPagamento(Carro carro, ProgressIndicator progress, Consumer<Void> chamarTelaCallback) {
        configPagamento(progress, chamarTelaCallback);
        CarroData.updateCarro(carro);
    }

    @Override
    public void montarTela(Stage stage) {
        FXMLLoader caminhoFXML = new FXMLLoader(MainApp.class.getResource("TelaDebito.fxml"));
        gerarTela(stage, caminhoFXML, 455, 455, "Pagamento Cartão de Débito");
    }
}