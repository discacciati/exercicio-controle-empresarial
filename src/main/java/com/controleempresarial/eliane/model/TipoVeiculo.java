package com.controleempresarial.eliane.model;

public enum TipoVeiculo {

    MOTO ("moto"),
    CARRO ("carro"),
    CAMINHAO ("caminhão");

    private String tipo;

    TipoVeiculo(String tipo){
        this.tipo = tipo;
    }

    public String getTipo(){
        return tipo;
    }

}