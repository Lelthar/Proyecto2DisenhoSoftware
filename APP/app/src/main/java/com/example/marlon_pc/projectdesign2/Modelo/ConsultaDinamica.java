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
public class ConsultaDinamica implements Consulta {
    
    private String consulta;


    @Override
    public String agregar(String valor) {
        return "SELECT codigoRegistro FROM Accidente WHERE"+valor+";";
    }
}
