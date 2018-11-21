package com.example.marlon_pc.projectdesign2.Modelo;

public class Sexo extends DecoradorConsulta {

    public Sexo(String valor, String nivel, Consulta consultaDecorada) {
        super(valor, nivel, consultaDecorada);
    }

    public String agregar(String valor){
        int lvl = Integer.parseInt(this.nivel);
        String inner ="";
        if(lvl==1){
            inner = " OR nombreSexo='"+this.valor+"'";
        }else if(lvl==2){
            inner = " AND nombreSexo='"+this.valor+"'";
        }else {
            inner = " nombreSexo='" + this.valor + "'";
        }
        return consultaDecorada.agregar(valor+inner);
    }
}
