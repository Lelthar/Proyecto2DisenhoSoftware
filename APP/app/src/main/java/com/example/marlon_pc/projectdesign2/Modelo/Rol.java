package com.example.marlon_pc.projectdesign2.Modelo;

public class Rol extends DecoradorConsulta {

    public Rol(String valor, String nivel, Consulta consultaDecorada) {
        super(valor, nivel, consultaDecorada);
    }
    public String agregar(String valor){
        int lvl = Integer.parseInt(this.nivel);
        String inner ="";
        if(lvl==1){
            inner = " OR nombreRol='"+this.valor+"'";
        }else if(lvl==2){
            inner = " AND nombreRol='"+this.valor+"'";
        }else {
            inner = " nombreRol='" + this.valor + "'";
        }
        return consultaDecorada.agregar(valor+inner);
    }
}
