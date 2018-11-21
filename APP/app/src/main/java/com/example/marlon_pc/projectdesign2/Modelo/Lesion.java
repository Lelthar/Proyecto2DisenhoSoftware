package com.example.marlon_pc.projectdesign2.Modelo;

public class Lesion extends DecoradorConsulta {

    public Lesion(String valor, String nivel, Consulta consultaDecorada) {
        super(valor, nivel, consultaDecorada);
    }

    public String agregar(String valor){
        int lvl = Integer.parseInt(this.nivel);
        String inner ="";
        if(lvl==1){
            inner = " OR nombreLesion='"+this.valor+"'";
        }else if(lvl==2){
            inner = " AND nombreLesion='"+this.valor+"'";
        }else {
            inner = " nombreLesion='" + this.valor + "'";
        }
        return consultaDecorada.agregar(valor+inner);
    }
}
