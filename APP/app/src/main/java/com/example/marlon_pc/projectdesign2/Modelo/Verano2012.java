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
public class Verano2012 extends Observador {
    
    
    
    public Verano2012(Sujeto sujeto){
      this.sujeto = sujeto;
      this.sujeto.agregarObservador(this);
   }

   @Override
   public Periodo actualizar(Resultado resultado) {
       
      return null; 
   }
    
}
