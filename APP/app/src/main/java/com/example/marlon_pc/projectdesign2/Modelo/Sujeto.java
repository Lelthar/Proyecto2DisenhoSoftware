/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.marlon_pc.projectdesign2.Modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author josed
 */
public class Sujeto {
    
    	private ArrayList<Observador> observadores = new ArrayList<>();
        private int estado;
        
        public int getEstado() {
            return estado;
        }
        
        public void setEstado(int estado) {
            this.estado = estado;
        }
        
        
        /*
        
        FALTA METODO NOTIFYALLOBSERVERS
        */




	public void agregarObservador(Observador observador){

		this.observadores.add(observador);
	}

	public boolean eliminarObservador(Class clase ){

	    Observador observadorTemporal;
	    for(int i = 0 ; i < this.observadores.size(); i++){

	        observadorTemporal = this.observadores.get(i);
	        if(observadorTemporal.getClass() == clase){

	            this.observadores.remove(observadorTemporal);
	            return true;
            }

        }
        return false;


    }
	public boolean eliminarObservador(int indice){

		try{
                    
                    Observador observadorEliminado = this.observadores.get(indice);
                    this.observadores.remove(observadorEliminado);
                    return true;
                }
                
                catch (Exception e){
                    return false;
                }

	}

	public Resultado ejecutar(Resultado resultado){

	    return null;
	}

	public String Imprimir(){

	    String resultado = "";

	    for(Observador observador: this.observadores){

	        resultado += observador.getClass();
        }
        System.out.println(resultado);
	    return resultado;
    }


    
}
