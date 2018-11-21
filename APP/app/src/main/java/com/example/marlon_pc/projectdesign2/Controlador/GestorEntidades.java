package com.example.marlon_pc.projectdesign2.Controlador;

import android.util.Log;

import com.example.marlon_pc.projectdesign2.GlobalClass;
import com.example.marlon_pc.projectdesign2.Modelo.Entidad;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class GestorEntidades {

    private ArrayList<Entidad> listaEntidades;

    public GestorEntidades() {
        this.listaEntidades = new ArrayList<>();
    }

    public ArrayList<Entidad> getListaEntidades() {
        return listaEntidades;
    }

    public void setListaEntidades(ArrayList<Entidad> listaEntidades) {
        this.listaEntidades = listaEntidades;
    }

    /**
     * Encargado de obtener las entidades del texto
     * @param texto
     * @return
     */
    public boolean obtenerEntidades(String texto){
        DaoWatson daoWatson = new DaoWatson(GlobalClass.VERSION,texto,GlobalClass.MODELO,GlobalClass.AUTENTIFICACION);
        if(daoWatson.enviarDatos()){
            if(this.procesarResultados(daoWatson.getResultado())){
                return true;
            }
        }
        return false;
    }

    /**
     * Encargado de convertir a la lista de entidades
     * @param entidades
     * @return
     */
    public boolean procesarResultados(String entidades){
        try {
            System.out.println(entidades);
            JSONObject JsonObjecto = new JSONObject(entidades);
            String sad = JsonObjecto.getString("entities");
            JSONArray datos = new JSONArray(sad);
            JSONObject elemento;
            Entidad entidad;
            for(int i=0;i<datos.length();i++){
                elemento = datos.getJSONObject(i);
                String tipo = elemento.getString("type");
                String text = elemento.getString("text");
                entidad = new Entidad(tipo,text);
                this.listaEntidades.add(entidad);
            }
            System.out.println(this.listaEntidades.toString());
            return true;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public String toString() {
        return "GestorEntidades{" +
                "listaEntidades=" + listaEntidades +
                '}';
    }
}
