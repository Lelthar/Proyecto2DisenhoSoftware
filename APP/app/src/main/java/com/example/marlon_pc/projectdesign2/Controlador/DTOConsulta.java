package com.example.marlon_pc.projectdesign2.Controlador;

import com.example.marlon_pc.projectdesign2.Modelo.Resultado;
import com.example.marlon_pc.projectdesign2.Modelo.Sujeto;

import java.io.Serializable;
import java.util.ArrayList;

public class DTOConsulta implements Serializable {
    private String tipo;
    private String entrada;
    private ArrayList<String> anhos;
    private Resultado resultado;
    private Sujeto sujeto;

    public DTOConsulta(String tipo, String entrada, ArrayList<String> anhos) {
        this.tipo = tipo;
        this.entrada = entrada;
        this.anhos = anhos;
        //this.resultado = new Resultado();
    }

    public void setSujeto(Sujeto sujeto){
        this.sujeto = sujeto;
    }

    public Sujeto getSujeto(){
        return this.sujeto;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEntrada() {
        return entrada;
    }

    public void setEntrada(String entrada) {
        this.entrada = entrada;
    }

    public ArrayList<String> getAnhos() {
        return anhos;
    }

    public void setAnhos(ArrayList<String> anhos) {
        this.anhos = anhos;
    }

    public Resultado getResultado() {
        return resultado;
    }

    public void setResultado(Resultado resultado) {
        this.resultado = resultado;
    }
}
