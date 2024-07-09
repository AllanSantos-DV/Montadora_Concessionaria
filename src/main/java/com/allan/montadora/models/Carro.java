package com.allan.montadora.models;

import com.allan.montadora.enuns.SituacaoCarro;
import com.allan.montadora.utils.PlacaMercosulGenerator;
import javafx.scene.paint.Color;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Carro implements Cloneable {

    private String placaMercosul;
    private String montadora;
    private String modelo;
    private Color cor;
    private Long valor;
    private String formaPagamento;
    private String situacao;

    @Override
    public Carro clone() {
        try {
            return (Carro) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("Clonagem não suportada", e);
        }
    }

    public void finalizarEmplacamento() {
        this.placaMercosul = PlacaMercosulGenerator.gerarPlacaMercosul();
        this.situacao = SituacaoCarro.DISPONIVEL.getSituacao();
    }
}

