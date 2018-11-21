package com.example.marlon_pc.projectdesign2.Modelo;

public class Rol extends DecoradorConsulta {

    public Rol(String valor, String nivel, Consulta consultaDecorada) {
        super(valor, nivel, consultaDecorada);
    }
    public String agregar(String valor){
        int lvl = Integer.parseInt(this.nivel);
        String inner ="";
        if(lvl==1){
            inner = " nombreRol='"+this.valor+"' OR";
        }else if(lvl==2){
            inner = " nombreRol='"+this.valor+"' AND";
        }else {
            inner = " nombreRol='" + this.valor + "'";
        }
        return consultaDecorada.agregar(valor+inner);
    }
}
