package com.allan.montadora.models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lombok.Getter;

import java.util.List;

public class CarroData {

    @Getter
    private static final ObservableList<Carro> carros = FXCollections.observableArrayList();

    public static void addCarro(Carro carro) {
        carros.add(carro);
    }

    public static void addCarros(List<Carro> novosCarros) {
        carros.addAll(novosCarros);
    }

    public static void updateCarro(Carro carro) {
        carros.stream().filter(c -> c.getPlacaMercosul().equals(carro.getPlacaMercosul()))
                .findFirst().ifPresent(c -> {
                    int index = carros.indexOf(c);
                    carros.set(index, carro);
                });
    }

    public static Carro buscarCarro(String placa) {
        return carros.stream().filter(c -> c.getPlacaMercosul().equals(placa)).findFirst().orElseThrow();
    }

    public static void removeCarro(Carro carro) {
        carros.remove(carro);
    }

    public static void clearCarros() {
        carros.clear();
    }
}
