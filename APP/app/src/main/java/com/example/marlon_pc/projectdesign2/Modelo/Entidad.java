package com.example.marlon_pc.projectdesign2.Modelo;

public class Entidad {
    private String tipo;
    private String valor;

    public Entidad(String tipo, String valor) {
        this.tipo = tipo;
        this.valor = valor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Entidad{" +
                "tipo='" + tipo + '\'' +
                ", valor='" + valor + '\'' +
                '}';
    }
}
