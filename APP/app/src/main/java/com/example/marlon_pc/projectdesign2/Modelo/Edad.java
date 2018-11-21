package com.example.marlon_pc.projectdesign2.Modelo;

public class Edad extends DecoradorConsulta  {

    public Edad(String valor, String nivel, Consulta consultaDecorada) {
        super(valor, nivel, consultaDecorada);
    }

    public String agregar(String valor){
        int lvl = Integer.parseInt(this.nivel);
        String inner ="";
        if(lvl==1){
            inner = " OR edad="+this.valor;
        }else if(lvl==2){
            inner = " AND edad="+this.valor;
        }else {
            inner = " edad=" + this.valor;
        }
        return consultaDecorada.agregar(valor+inner);
    }
}
