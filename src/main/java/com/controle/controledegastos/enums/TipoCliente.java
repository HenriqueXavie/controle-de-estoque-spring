package com.controle.controledegastos.enums;

public enum TipoCliente {

    PESSOA_FISICA(1, "Pessoa Física"),
    PESSOA_JURIDICA(2, "Pessoa Jurídica");

    private int cod;
    private String descricao;

    private TipoCliente(int codigo, String descricao) {
        this.cod = codigo;
        this.descricao = descricao;
    }

    public int getCod() {
        return cod;
    }

    public String getDescricao() {
        return descricao;
    }

    public static TipoCliente toEnum(Integer cod) {
        if (cod == null) {
            return null;
        }
        for (TipoCliente x : TipoCliente.values()) {
            if (cod.equals(x.getCod())) {
                return x;
            }
        }
        throw new IllegalArgumentException("id inválido: "+cod);
    }
}

