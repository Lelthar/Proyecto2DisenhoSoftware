package com.example.marlon_pc.projectdesign2.Modelo;

import java.util.ArrayList;

public class ResultadoConsultaVacaciones extends Resultado {


    private ArrayList<Periodo> periodos;
    String resultado;

    public ResultadoConsultaVacaciones(ArrayList<Periodo> periodos, String resultado) {
        this.periodos = new ArrayList<>();
        this.resultado = resultado;
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
