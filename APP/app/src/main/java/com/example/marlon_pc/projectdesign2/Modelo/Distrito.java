package com.example.marlon_pc.projectdesign2.Modelo;

public class Distrito extends DecoradorConsulta{

    public Distrito(String valor, String nivel, Consulta consultaDecorada) {
        super(valor, nivel, consultaDecorada);
    }

    public String agregar(String valor){
        int lvl = Integer.parseInt(this.nivel);
        String inner ="";
        if(lvl==1){
            inner = " nombreDistrito='"+this.valor+"' OR";
        }else if(lvl==2){
            inner = " nombreDistrito='"+this.valor+"' AND";
        }else {
            inner = " nombreDistrito='" + this.valor + "'";
        }
        return consultaDecorada.agregar(valor+inner);
    }
}
