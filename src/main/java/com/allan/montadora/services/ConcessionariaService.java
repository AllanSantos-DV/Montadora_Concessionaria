package com.allan.montadora.services;

import com.allan.montadora.MainApp;
import com.allan.montadora.enuns.SituacaoCarro;
import com.allan.montadora.interfaces.TelaManager;
import com.allan.montadora.models.Carro;
import com.allan.montadora.models.CarroData;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

import static com.allan.montadora.utils.GeradorTela.gerarTela;

public class ConcessionariaService implements TelaManager {

    private static ConcessionariaService instance;

    public static ConcessionariaService getTelaConcessionaria() {
        if (instance == null) {
            instance = new ConcessionariaService();
        }
        return instance;
    }

    @Override
    public void montarTela(Stage stage) {
        FXMLLoader caminhoFXML = new FXMLLoader(MainApp.class.getResource("Concessionaria.fxml"));
        gerarTela(stage, caminhoFXML, 800, 600, "Concessionária");
    }

    public void vendaCarro(String placa, String formaPagamento, long valor) {
        Carro carro = CarroData.buscarCarro(placa);
        Carro carroUpdated = Carro.builder()
                .placaMercosul(placa)
                .montadora(carro.getMontadora())
                .modelo(carro.getModelo())
                .cor(carro.getCor())
                .valor(valor)
                .formaPagamento(formaPagamento)
                .situacao(SituacaoCarro.VENDIDO.getSituacao())
                .build();
        CarroData.updateCarro(carroUpdated);
    }

}
