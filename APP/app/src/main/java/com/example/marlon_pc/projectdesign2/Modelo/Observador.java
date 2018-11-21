/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package package com.example.marlon_pc.projectdesign2.Modelo;

/**
 *
 * @author josed
 */
public abstract class Observador {
    
    protected Sujeto sujeto;   
    public abstract Periodo actualizar(Resultado resultado);
    
}
