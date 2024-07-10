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
public class PagamentoCartaoCredito implements Pagamento {

    private PagamentoCartaoCredito() {}

    @Override
    public void realizarPagamento(Carro carro, ProgressIndicator progress, Consumer<Void> chamarTelaCallback) {
        configPagamento(progress, chamarTelaCallback);
        CarroData.updateCarro(carro);
    }

    @Override
    public void montarTela(Stage stage) {
        FXMLLoader caminhoFXML = new FXMLLoader(MainApp.class.getResource("TelaCredito.fxml"));
        gerarTela(stage, caminhoFXML, 470, 440, "Pagamento Cartão de Crédito");
    }

    public Long configParcelas(int parcelas, Long valor) {
        double juros_inicial = 0.09;
        if (parcelas <= 6) return valor;
        double valorComJuros = valor * Math.pow(1 + juros_inicial, (parcelas - 6) / 6.0);
        return Math.round(valorComJuros);
    }
}