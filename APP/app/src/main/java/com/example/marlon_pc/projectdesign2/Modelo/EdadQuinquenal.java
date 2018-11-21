package com.example.marlon_pc.projectdesign2.Modelo;

public class EdadQuinquenal extends  DecoradorConsulta {

    public EdadQuinquenal(String valor, String nivel, Consulta consultaDecorada) {
        super(valor, nivel, consultaDecorada);
    }

    public String agregar(String valor){
        int lvl = Integer.parseInt(this.nivel);
        String inner ="";
        if(lvl==1){
            inner = " edadQuinquenal='"+this.valor+"' OR";
        }else if(lvl==2){
            inner = " edadQuinquenal='"+this.valor+"' AND";
        }else {
            inner = " edadQuinquenal='" + this.valor + "'";
        }
        return consultaDecorada.agregar(valor+inner);
    }
}
