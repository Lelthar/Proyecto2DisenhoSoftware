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

		public boolean obs2012 = false;
		public boolean obs2013 = false;
		public boolean obs2014 = false;
		public boolean obsVerano =  false;
		public boolean obsMediados = false;
		public boolean obsSemanaSanta  = false;
        


	public void agregarObservador(Observador observador){

		this.observadores.add(observador);

		if(observador instanceof Observer2012){
			this.obs2012 = true;
		}
		else if(observador instanceof Observer2013 ){
			this.obs2013 = true;
		}
		else if(observador instanceof  Observer2014){
			this.obs2014 = true;
		}
		else if(observador instanceof ObserverMediados){
			this.obsMediados = true;
		}
		else if(observador instanceof ObserverSemanaSanta){
			this.obsSemanaSanta = true;
		}
		else if(observador instanceof  ObserverVerano){
			this.obsVerano = true;
		}

	}

	public boolean eliminarObservador(Class clase ){

	    Observador observadorTemporal;
	    for(int i = 0 ; i < this.observadores.size(); i++){

	        observadorTemporal = this.observadores.get(i);

	        if(observadorTemporal.getClass() == clase){

	            this.observadores.remove(observadorTemporal);

				if(observadorTemporal instanceof Observer2012){
					this.obs2012 = false;
				}
				else if(observadorTemporal instanceof Observer2013 ){
					this.obs2013 = false;
				}
				else if(observadorTemporal instanceof  Observer2014){
					this.obs2014 = false;
				}
				else if(observadorTemporal instanceof ObserverMediados){
					this.obsMediados = false;
				}
				else if(observadorTemporal instanceof ObserverSemanaSanta){
					this.obsSemanaSanta = false;
				}
				else if(observadorTemporal instanceof  ObserverVerano){
					this.obsVerano = false;
				}

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
