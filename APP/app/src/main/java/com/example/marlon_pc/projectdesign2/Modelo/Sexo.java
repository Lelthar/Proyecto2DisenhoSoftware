package com.example.marlon_pc.projectdesign2.Modelo;

public class Sexo extends DecoradorConsulta {

    public Sexo(String valor, String nivel, Consulta consultaDecorada) {
        super(valor, nivel, consultaDecorada);
    }

    public String agregar(String valor){
        int lvl = Integer.parseInt(this.nivel);
        String inner ="";
        if(lvl==1){
            inner = " nombreSexo='"+this.valor+"' OR";
        }else if(lvl==2){
            inner = " nombreSexo='"+this.valor+"' AND";
        }else {
            inner = " nombreSexo='" + this.valor + "'";
        }
        return consultaDecorada.agregar(valor+inner);
    }
}
