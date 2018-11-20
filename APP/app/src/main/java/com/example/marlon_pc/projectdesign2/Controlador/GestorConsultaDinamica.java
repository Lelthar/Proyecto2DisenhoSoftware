package com.example.marlon_pc.projectdesign2.Controlador;

import android.util.Log;

import com.example.marlon_pc.projectdesign2.Modelo.Consulta;

public class GestorConsultaDinamica implements GestorConsulta{
    private GestorEntidades gestorEntidades;

    public GestorConsultaDinamica() {
        this.gestorEntidades = new GestorEntidades();
    }

    public GestorEntidades getGestorEntidades() {
        return gestorEntidades;
    }

    public void setGestorEntidades(GestorEntidades gestorEntidades) {
        this.gestorEntidades = gestorEntidades;
    }

    @Override
    public String efectuarConsulta(DTOConsulta dto) {
        if(gestorEntidades.obtenerEntidades(dto.getEntrada())){
            if(validar()){

            }
            Log.i("Lista Valores:",gestorEntidades.toString());
        }else{
            return "Problema Watson";
        }
        return "";
    }

    @Override
    public Consulta construirConsulta() {
        return null;
    }

    @Override
    public String consultar(Consulta consulta) {
        return null;
    }

    /**
     * Validar:
     *      No existan cantones si hay 2 o más provincias
     *      No existan distritos si hay 2 o más cantones
     * @return
     */
    public boolean validar(){
        return true;
    }
}
