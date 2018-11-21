/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.marlon_pc.projectdesign2.Modelo;

import android.util.Log;

/**
 *
 * @author josed
 */
public class Provincia extends DecoradorConsulta{


    public Provincia(String valor, String nivel, Consulta consultaDecorada) {
        super(valor, nivel, consultaDecorada);
    }

    public String agregar(String valor){
        int lvl = Integer.parseInt(this.nivel);
        String inner ="";
        if(lvl==1){
            inner = " OR nombreProvincia='"+this.valor+"'";
        }else if(lvl==2){
            inner = " AND nombreProvincia='"+this.valor+"'";
        }else{
            inner = " nombreProvincia='"+this.valor+"'";
        }
        return consultaDecorada.agregar(valor+inner);
    }

}
