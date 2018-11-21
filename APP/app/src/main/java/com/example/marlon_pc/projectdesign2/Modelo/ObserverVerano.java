package com.example.marlon_pc.projectdesign2.Modelo;

public class ObserverVerano extends Observador{

    private Sujeto sujeto;

    public ObserverVerano(Sujeto sujeto){
        this.sujeto = sujeto;
        this.sujeto.agregarObservador(this);
    }

    @Override
    public Periodo actualizar(Resultado resultado) {

        return null;
    }

}

