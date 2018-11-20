package com.example.marlon_pc.projectdesign2.Modelo;

import java.util.ArrayList;

public class ResultadoConsultaDinamica extends  Resultado{
    private ArrayList<Ubicacion> ubicaciones;

    public ResultadoConsultaDinamica() {
        this.ubicaciones = new ArrayList<>();
    }

    public ArrayList<Ubicacion> getUbicaciones() {
        return ubicaciones;
    }

    public void setUbicaciones(ArrayList<Ubicacion> ubicaciones) {
        this.ubicaciones = ubicaciones;
    }

    @Override
    public String toString() {
        return "ResultadoConsultaDinamica{" +
                "ubicaciones=" + ubicaciones +
                '}';
    }
}
