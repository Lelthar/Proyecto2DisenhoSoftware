package com.example.marlon_pc.projectdesign2.Modelo;

public class Observer2012 extends Observador{

    private Sujeto sujeto;

    public Observer2012(Sujeto sujeto){
        this.sujeto = sujeto;
        this.sujeto.agregarObservador(this);
    }

    @Override
    public Periodo actualizar(Resultado resultado) {

        return null;
    }

}

