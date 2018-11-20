package com.example.marlon_pc.projectdesign2.Modelo;

import java.util.ArrayList;

public class ResultadoConsultaVaciones extends Resultado {
    private ArrayList<Periodo> periodos;

    public ResultadoConsultaVaciones(ArrayList<Periodo> periodos) {
        this.periodos = new ArrayList<>();
    }

    public ArrayList<Periodo> getPeriodos() {
        return periodos;
    }

    public void setPeriodos(ArrayList<Periodo> periodos) {
        this.periodos = periodos;
    }

    @Override
    public String toString() {
        return "ResultadoConsultaVaciones{" +
                "periodos=" + periodos +
                '}';
    }
}
