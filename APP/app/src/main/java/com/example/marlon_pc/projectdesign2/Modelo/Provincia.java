/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.marlon_pc.projectdesign2.Modelo;

/**
 *
 * @author josed
 */
public class Provincia extends DecoradorConsulta{
    
    private String valor;
    
    public Provincia(Consulta consultaDecorada){
        super(consultaDecorada);
        
    }
    
    
    public void agregar(String valor){
        consultaDecorada.agregar(valor);
    }
    
    
    
}
