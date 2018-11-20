package com.example.marlon_pc.projectdesign2.Modelo;

public class Ubicacion {
    private int latitud;
    private int longitud;
    private int cantidad;

    public Ubicacion(int latitud, int longitud, int cantidad) {
        this.latitud = latitud;
        this.longitud = longitud;
        this.cantidad = cantidad;
    }

    public int getLatitud() {
        return latitud;
    }

    public void setLatitud(int latitud) {
        this.latitud = latitud;
    }

    public int getLongitud() {
        return longitud;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Ubicacion{" +
                "latitud=" + latitud +
                ", longitud=" + longitud +
                ", cantidad=" + cantidad +
                '}';
    }

}
