package com.example.marlon_pc.projectdesign2.Modelo;

public class Anho extends DecoradorConsulta {
    public Anho(String valor, String nivel, Consulta consultaDecorada) {
        super(valor, nivel, consultaDecorada);
    }

    public String agregar(String valor){
        int lvl = Integer.parseInt(this.nivel);
        String inner ="";
        if(lvl==1){
            inner = " OR nombreAnho='"+this.valor+"'";
        }else if(lvl==2){
            inner = " AND nombreAnho='"+this.valor+"'";
        }else {
            inner = " nombreAnho='" + this.valor + "'";
        }
        return consultaDecorada.agregar(valor+inner);
    }
}
