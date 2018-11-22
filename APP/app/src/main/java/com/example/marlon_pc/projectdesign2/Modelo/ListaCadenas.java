package com.example.marlon_pc.projectdesign2.Modelo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ListaCadenas implements Contenedor {

    public JSONArray estadisticas;

    public ListaCadenas(JSONArray estadisticas) {
        this.estadisticas = estadisticas;
    }

    @Override
    public Iterador getIterador() {
        return new CadenaIterador();
    }

    public class CadenaIterador implements Iterador{

        public int indice;

        @Override
        public JSONObject siguiente() {
            if(hasSiguiente()){
                try {
                    return estadisticas.getJSONObject(indice++);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        public boolean hasSiguiente() {
            return indice<estadisticas.length();
        }
    }

}
