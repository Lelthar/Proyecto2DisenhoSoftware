package com.example.marlon_pc.projectdesign2.Modelo;

public class Estadistica {
    private String identificador;
    private int cantidad;

    public Estadistica(String identificador, int cantidad) {
        this.identificador = identificador;
        this.cantidad = cantidad;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Estadistica{" +
                "identificador='" + identificador + '\'' +
                ", cantidad=" + cantidad +
                '}';
    }
}
