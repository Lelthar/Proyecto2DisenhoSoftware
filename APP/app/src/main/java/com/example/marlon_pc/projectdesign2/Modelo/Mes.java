package com.example.marlon_pc.projectdesign2.Modelo;

public class Mes extends DecoradorConsulta{

    public Mes(String valor, String nivel, Consulta consultaDecorada) {
        super(valor, nivel, consultaDecorada);
    }

    public String agregar(String valor){
        int lvl = Integer.parseInt(this.nivel);
        String inner ="";
        if(lvl==1){
            inner = " nombreMes='"+this.valor+"' OR";
        }else if(lvl==2){
            inner = " nombreMes='"+this.valor+"') AND (";
        }else {
            inner = " nombreMes='" + this.valor + "'";
        }
        return consultaDecorada.agregar(valor+inner);
    }
}
