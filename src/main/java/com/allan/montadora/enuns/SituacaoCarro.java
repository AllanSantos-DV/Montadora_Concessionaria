package com.allan.montadora.enuns;

import lombok.Getter;

@Getter
public enum SituacaoCarro {

    DISPONIVEL(1, "Disponível"),
    VENDIDO(2, "Vendido"),
    EMPLACANDO(3, "Emplacando");

    private final int cod;
    private final String situacao;

    SituacaoCarro(int cod, String situacao) {
        this.cod = cod;
        this.situacao = situacao;
    }

    public static String getSituacao(int cod) {
        for (SituacaoCarro situacao : SituacaoCarro.values()) {
            if (situacao.getCod() == cod) {
                return situacao.getSituacao();
            }
        }
        return null;
    }

}
