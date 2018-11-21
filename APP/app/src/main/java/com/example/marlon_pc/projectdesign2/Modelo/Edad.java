package com.example.marlon_pc.projectdesign2.Modelo;

public class Edad extends DecoradorConsulta  {

    public Edad(String valor, String nivel, Consulta consultaDecorada) {
        super(valor, nivel, consultaDecorada);
    }

    public String agregar(String valor){
        int lvl = Integer.parseInt(this.nivel);
        String inner ="";
        if(lvl==1){
            inner = " edad='"+this.valor+"' OR";
        }else if(lvl==2){
            inner = " edad='"+this.valor+"') AND (";
        }else {
            inner = " edad=" + this.valor;
        }
        return consultaDecorada.agregar(valor+inner);
    }
}
