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
public class DecoradorConsulta implements Consulta {

    protected String valor;
    protected String nivel;
    protected Consulta consultaDecorada;

    public DecoradorConsulta(String valor, String nivel, Consulta consultaDecorada) {
        this.valor = valor;
        this.nivel = nivel;
        this.consultaDecorada = consultaDecorada;
    }

    public String agregar(String valor){
        return consultaDecorada.agregar(valor);
    }

}
