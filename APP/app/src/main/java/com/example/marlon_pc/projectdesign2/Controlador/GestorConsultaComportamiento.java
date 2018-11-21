package com.example.marlon_pc.projectdesign2.Controlador;

import android.util.Log;

import com.example.marlon_pc.projectdesign2.GlobalClass;
import com.example.marlon_pc.projectdesign2.Modelo.Consulta;
import com.example.marlon_pc.projectdesign2.Modelo.Entidad;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;

public class GestorConsultaComportamiento implements GestorConsulta {

    @Override
    public String efectuarConsulta(DTOConsulta dto) {
        String indicadores = this.obtenerIndicadores(dto.getEntrada());
        try {
            JSONObject jsonObject = new JSONObject(indicadores);
            String sad = jsonObject.getString("value");
            JSONArray datos = new JSONArray(sad);
            JSONObject elemento;
            Entidad entidad;
            for(int i=0;i<datos.length();i++){
                elemento = datos.getJSONObject(i);
                String tipo = elemento.getString("type");
                String text = elemento.getString("text");
                entidad = new Entidad(tipo,text);
            }
            Log.i("INDICADORES",sad);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
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
     * Metodo encargado de obtener los valores posibles de un indicador
     * @param indicador
     * @return
     */
    public String obtenerIndicadores(String indicador){
        String result = "";

        Conexion conexion = new Conexion();

        String tabla = "";
        if(indicador.equals("Años")){
            indicador="Anhos";
        }

        tabla = indicador;

        String consulta = GlobalClass.ALL_VALOR+tabla+".php";
        try {
            result = conexion.execute(consulta,"GET").get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return result;
    }

    /**
     * Encargado de convertir a la lista de entidades
     * @param entidades
     * @return
     */
    public boolean procesarResultados(String entidades){
        try {
            //System.out.println(entidades);
            if(!entidades.equals("Error")){
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
                    //this.listaEntidades.add(entidad);
                }
                //ordenarResultados();
                //System.out.println(this.listaEntidades.toString());
                return true;
            }else{
                return false;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return false;
    }
}
