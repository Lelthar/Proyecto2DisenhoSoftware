package com.example.marlon_pc.projectdesign2.Controlador;

import android.util.Log;

import com.example.marlon_pc.projectdesign2.GlobalClass;
import com.example.marlon_pc.projectdesign2.Modelo.Consulta;
import com.example.marlon_pc.projectdesign2.Modelo.ConsultaVacaciones;
import com.example.marlon_pc.projectdesign2.Modelo.Entidad;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;

public class GestorConsultaVacaciones implements GestorConsulta{



    private GestorEntidades gestorEntidades;

    public GestorConsultaVacaciones() {

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

        Consulta consulta = this.construirConsulta();
       // DaoBaseDatos daoBaseDatos = new DaoBaseDatos();


        return "";

    }

    @Override
    public Consulta construirConsulta() {

        Consulta consulta = new ConsultaVacaciones();
        return consulta;
    }

    @Override
    public String consultar(Consulta consulta) {
        return null;
    }




}
