package com.allan.montadora.services;

import com.allan.montadora.MainApp;
import com.allan.montadora.enuns.Montadora;
import com.allan.montadora.enuns.SituacaoCarro;
import com.allan.montadora.interfaces.TelaManager;
import com.allan.montadora.models.Carro;
import com.allan.montadora.models.CarroData;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import lombok.extern.log4j.Log4j2;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

import static com.allan.montadora.utils.AlertUtil.showAlert;
import static com.allan.montadora.utils.GeradorTela.gerarTela;
import static java.lang.Thread.sleep;

@Log4j2
public class MontadoraService implements TelaManager {

    private MontadoraService() {}

    private Carro carro;

    @Override
    public void montarTela(Stage stage) {
        FXMLLoader caminhoFXML = new FXMLLoader(MainApp.class.getResource("Montadora.fxml"));
        gerarTela(stage, caminhoFXML, 540, 340, "Montadora de Carros");
    }

    public void getMontadora(ComboBox<String> comboBoxMontadoras, ComboBox<String> comboBoxModelos) {
        String montadora = comboBoxMontadoras.getValue() == null || comboBoxMontadoras.getValue().isEmpty() ? null : comboBoxMontadoras.getValue();
        comboBoxModelos.setDisable(montadora == null);
        comboBoxModelos.getItems().clear();
        if (montadora == null) {
            log.info("Montadora não informada.");
            return;
        }
        comboBoxModelos.getItems().addAll(Objects.requireNonNull(Montadora.getModels(montadora)));
        carro = Carro.builder().montadora(montadora).build();
        log.info("Carro com montadora: {}", carro);
    }

    public void getModelo(ComboBox<String> comboBoxModelos, ColorPicker selectCores) {
        String modelo = comboBoxModelos.getValue();
        selectCores.setDisable(modelo == null);
        if (modelo == null) {
            log.info("Modelo não informado.");
            return;
        }
        carro = Carro.builder()
                .montadora(carro.getMontadora())
                .modelo(modelo).build();
        log.info("Carro com modelo: {}", carro);
    }

    public void getCor(ColorPicker selectCores, Spinner<Integer> qtdCarros) {
        Color cor = selectCores.getValue() == null || selectCores.getValue().toString().isEmpty() ? null : selectCores.getValue();
        qtdCarros.setDisable(cor == null);
        if (cor == null) {
            log.info("Cor não informada.");
            return;
        }
        carro = Carro.builder()
                .montadora(carro.getMontadora())
                .modelo(carro.getModelo())
                .cor(cor)
                .situacao(SituacaoCarro.EMPLACANDO.getSituacao())
                .build();
        log.info("Carro com cor: {}", carro);
    }

    public void gerarCarros(Spinner<Integer> qtdCarros, ProgressBar progressBar) {
        int value = qtdCarros.getValue() == null ? 0 : qtdCarros.getValue();
        progressBar.setDisable(value == 0);

        if (carro == null) {
            log.info("Carro não informado.");
            return;
        }
        Carro carroClone = carro.clone();
        Task<List<Carro>> task = gerarCarros(carroClone, value, progressBar);

        Thread thread = new Thread(task);
        thread.setDaemon(true);
        thread.start();
        showAlert(Alert.AlertType.INFORMATION, "Geração de Carros Iniciada", "A geração de " + value + " carros foi iniciada!");
    }

    private Task<List<Carro>> gerarCarros(Carro clone, int value, ProgressBar progressBar) {
        return new Task<>() {
            @Override
            protected List<Carro> call() {
                int timeRandom = (int) (Math.random() * 3000) + 600;
                return LongStream.range(0, value)
                        .mapToObj(i -> {
                            try {
                                sleep(timeRandom);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                            final double progress = (double) (i + 1) / value;
                            Platform.runLater(() -> progressBar.setProgress(progress));
                            return getCarro(clone);
                        })
                        .collect(Collectors.toList());
            }

            @Override
            protected void succeeded() {
                super.succeeded();
                CarroData.getCarros().forEach(Carro::finalizarEmplacamento);
                CarroData.getCarros().sort(
                        Comparator
                                .comparing(Carro::getMontadora)
                                .thenComparing(Carro::getPlacaMercosul)
                                .thenComparing(Carro::getModelo)
                                .reversed()
                );
            }

            @Override
            protected void failed() {
                super.failed();
                Throwable throwable = getException();
                log.error("Erro ao gerar carros", throwable);
            }
        };
    }

    private Carro getCarro(Carro carro) {
        Carro carroClone = carro.clone();
        CarroData.addCarro(carroClone);
        return carroClone;
    }
}