package com.allan.montadora.enuns;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public enum Montadora {
    VOLKSWAGEN("Volkswagen",
            new String[]{"Voyage", "Gol", "Fusca", "Polo", "Jetta"}),
    FIAT("Fiat",
            new String[]{"Uno", "Palio", "Toro", "Mobi", "Argo"}),
    RENAULT("Renault",
            new String[]{"Kwid", "Sandero", "Duster", "Captur", "Logan"}),
    TOYOTA("Toyota",
            new String[]{"Corolla", "Hilux", "Yaris", "Etios", "Rav4"}),
    HYUNDAI("Hyundai",
            new String[]{"HB20", "Creta", "i30", "Tucson", "Santa Fe"}),
    CHEVROLET("Chevrolet",
            new String[]{"Onix", "Prisma", "Cruze", "Tracker", "S10"}),
    FORD("Ford",
            new String[]{"Ka", "Fiesta", "EcoSport", "Ranger", "Mustang"}),
    HONDA("Honda",
            new String[]{"Civic", "HR-V", "Fit", "City", "CR-V"}),
    BMW("BMW",
            new String[]{"X1", "Série 3", "X3", "Série 1", "X5"}),
    MERCEDES_BENZ("Mercedes-Benz",
            new String[]{"Classe A", "Classe C", "Classe E", "GLA", "GLC"});

    private final String nomeMontadora;
    private final String[] modelos;

    Montadora(String nomeMontadora, String[] modelos) {
        this.nomeMontadora = nomeMontadora;
        this.modelos = modelos;
    }

    public static List<String> getMontadoras() {
        List<String> montadoras = new ArrayList<>();
        for (Montadora montadora : Montadora.values()) {
            montadoras.add(montadora.getNomeMontadora());
        }
        return montadoras;
    }

    public static List<String> getModels(String nomeMontadora) {
        for (Montadora montadora : Montadora.values()) {
            if (montadora.getNomeMontadora().equals(nomeMontadora)) {
                return List.of(montadora.getModelos());
            }
        }
        return null;
    }

}

