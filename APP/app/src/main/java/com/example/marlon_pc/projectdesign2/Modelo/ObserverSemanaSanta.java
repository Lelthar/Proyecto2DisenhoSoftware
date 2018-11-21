package com.example.marlon_pc.projectdesign2.Modelo;

public class ObserverSemanaSanta extends Observador{

    private Sujeto sujeto;

    public ObserverSemanaSanta(Sujeto sujeto){
        this.sujeto = sujeto;
        this.sujeto.agregarObservador(this);
    }

    @Override
    public Periodo actualizar(Resultado resultado) {

        return null;
    }

}

