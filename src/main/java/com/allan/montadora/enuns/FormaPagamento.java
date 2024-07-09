package com.allan.montadora.enuns;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public enum FormaPagamento {
    DINHEIRO(1, "Dinheiro"),
    CARTAO_CREDITO(2, "Cartão de Crédito"),
    CARTAO_DEBITO(3, "Cartão de Débito"),
    PIX(4, "PIX");

    private final int codigo;
    private final String descricao;

    FormaPagamento(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public static FormaPagamento getFormaPagamento(int codigo) {
        for (FormaPagamento formaPagamento : FormaPagamento.values()) {
            if (formaPagamento.getCodigo() == codigo) {
                return formaPagamento;
            }
        }
        return null;
    }

    public static FormaPagamento getFormaPagamento(String descricao) {
        for (FormaPagamento formaPagamento : FormaPagamento.values()) {
            if (formaPagamento.getDescricao().equalsIgnoreCase(descricao)) {
                return formaPagamento;
            }
        }
        return null;
    }

    public static List<String> getFormasPagamento() {
        List<String> formasPagamento = new ArrayList<>();
        for (FormaPagamento formaPagamento : FormaPagamento.values()) {
            formasPagamento.add(formaPagamento.getDescricao());
        }
        return formasPagamento;
    }

}

