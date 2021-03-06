package com.example.marlon_pc.projectdesign2.Modelo;

public class Canton extends DecoradorConsulta {

    public Canton(String valor, String nivel, Consulta consultaDecorada) {
        super(valor, nivel, consultaDecorada);
    }

    public String agregar(String valor){
        int lvl = Integer.parseInt(this.nivel);
        String inner ="";
        if(lvl==1){
            inner = " nombreCanton='"+this.valor+"' OR";
        }else if(lvl==2){
            inner = " nombreCanton='"+this.valor+"') AND (";
        }else {
            inner = " nombreCanton='" + this.valor + "'";
        }
        return consultaDecorada.agregar(valor+inner);
    }
}
