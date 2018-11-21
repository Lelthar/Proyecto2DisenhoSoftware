package com.example.marlon_pc.projectdesign2.Modelo;

public class Dia extends DecoradorConsulta {

    public Dia(String valor, String nivel, Consulta consultaDecorada) {
        super(valor, nivel, consultaDecorada);
    }

    public String agregar(String valor){
        int lvl = Integer.parseInt(this.nivel);
        String inner ="";
        if(lvl==1){
            inner = " nombreDia='"+this.valor+"' OR";
        }else if(lvl==2){
            inner = " nombreDiao='"+this.valor+"') AND (";
        }else {
            inner = " nombreDia='" + this.valor + "'";
        }
        return consultaDecorada.agregar(valor+inner);
    }
}
