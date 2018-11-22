package com.example.marlon_pc.projectdesign2.Modelo;

public class Ubicacion {

    private String direccion;
    private int cantidad;

    public Ubicacion(String direccion, int cantidad) {
        this.direccion = direccion;
        this.cantidad = cantidad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String
    toString() {
        return "Ubicacion{" +
                "direccion='" + direccion + '\'' +
                ", cantidad=" + cantidad +
                '}';
    }
}
