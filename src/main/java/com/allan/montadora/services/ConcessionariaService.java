package com.allan.montadora.services;

import com.allan.montadora.MainApp;
import com.allan.montadora.enuns.FormaPagamento;
import com.allan.montadora.enuns.SituacaoCarro;
import com.allan.montadora.interfaces.FabricaPagamento;
import com.allan.montadora.interfaces.TelaManager;
import com.allan.montadora.models.Carro;
import com.allan.montadora.models.CarroData;
import com.allan.montadora.utils.FabricaPagamentos;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextFormatter;
import javafx.stage.Stage;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;

import static com.allan.montadora.MainApp.stage;
import static com.allan.montadora.utils.GeradorTela.gerarTela;

@Log4j2
public class ConcessionariaService implements TelaManager {

    @Getter
    private static Carro carroUpdated;

    private ConcessionariaService() {}

    @Override
    public void montarTela(Stage stage) {
        FXMLLoader caminhoFXML = new FXMLLoader(MainApp.class.getResource("Concessionaria.fxml"));
        gerarTela(stage, caminhoFXML, 800, 600, "Concessionária");
    }

    public void configSpinner(Spinner<Integer> valorVeiculo) {
        valorVeiculo.setDisable(true);

        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 1000000, 0, 1000);
        TextFormatter<Integer> formatter = new TextFormatter<>(valueFactory.getConverter(), valueFactory.getValue(), change -> {
            String newText = change.getControlNewText();
            if (newText.matches("\\d*")) return change;
            return null;
        });

        formatter.valueProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue != null) valueFactory.setValue(newValue);
        });

        valorVeiculo.getEditor().setTextFormatter(formatter);
        valorVeiculo.setValueFactory(valueFactory);
    }

    public void vendaCarro(String placa, FormaPagamento formaPagamento, long valor) {
        Carro carro = CarroData.buscarCarro(placa);
        carroUpdated = Carro.builder()
                .placaMercosul(placa)
                .montadora(carro.getMontadora())
                .modelo(carro.getModelo())
                .cor(carro.getCor())
                .valor(valor)
                .formaPagamento(formaPagamento.getDescricao())
                .situacao(SituacaoCarro.VENDIDO.getSituacao())
                .build();
        telaConfirmaVenda(formaPagamento);
    }

    private void telaConfirmaVenda(FormaPagamento formaPagamento) {
        FabricaPagamento fabricaPagamento = FabricaPagamentos.getFabricaPagamento(formaPagamento);
        fabricaPagamento.criarPagamento().montarTela(stage);
    }
}