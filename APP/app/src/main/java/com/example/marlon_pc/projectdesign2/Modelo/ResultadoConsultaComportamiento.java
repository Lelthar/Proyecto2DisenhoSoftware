package com.example.marlon_pc.projectdesign2.Modelo;

import java.util.ArrayList;

public class ResultadoConsultaComportamiento extends Resultado{
    private ArrayList<Estadistica> estadisticas;

    public ResultadoConsultaComportamiento() {
        this.estadisticas = new ArrayList<>();
    }

    public ArrayList<Estadistica> getEstadisticas() {
        return estadisticas;
    }

    public void setEstadisticas(ArrayList<Estadistica> estadisticas) {
        this.estadisticas = estadisticas;
    }

    @Override
    public String toString() {
        return "ResultadoConsultaComportamiento{" +
                "estadisticas=" + estadisticas +
                '}';
    }
}
