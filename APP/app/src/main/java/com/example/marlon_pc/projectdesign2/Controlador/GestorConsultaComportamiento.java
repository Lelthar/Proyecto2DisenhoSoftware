package com.example.marlon_pc.projectdesign2.Controlador;

import android.util.Log;

import com.example.marlon_pc.projectdesign2.GlobalClass;
import com.example.marlon_pc.projectdesign2.Modelo.Consulta;
import com.example.marlon_pc.projectdesign2.Modelo.ConsultaComportamiento;
import com.example.marlon_pc.projectdesign2.Modelo.Entidad;
import com.example.marlon_pc.projectdesign2.Modelo.Estadistica;
import com.example.marlon_pc.projectdesign2.Modelo.Iterador;
import com.example.marlon_pc.projectdesign2.Modelo.ListaCadenas;
import com.example.marlon_pc.projectdesign2.Modelo.Resultado;
import com.example.marlon_pc.projectdesign2.Modelo.ResultadoConsultaComportamiento;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class GestorConsultaComportamiento implements GestorConsulta {

    @Override
    public String efectuarConsulta(DTOConsulta dto) {

        try {
            Consulta consult = construirConsulta();

            String indicadores = consultarIndicador(consult,dto.getEntrada());

            JSONObject jsonObject = new JSONObject(indicadores);

            String sad = jsonObject.getString("value");

            JSONArray datos = new JSONArray(sad);

            ListaCadenas listaCadenas = new ListaCadenas(datos);

            ResultadoConsultaComportamiento result = new ResultadoConsultaComportamiento();

            ArrayList<Estadistica> estadisticas = new ArrayList<>();

            Estadistica estadistica;
            for(Iterador iterador = listaCadenas.getIterador();iterador.hasSiguiente();){
                JSONObject json = iterador.siguiente();

                String identificador = json.getString("nombre"+dto.getEntrada());
                int cantidad = Integer.parseInt(json.getString("COUNT(codigoRegistro)"));

                estadistica = new Estadistica(identificador,cantidad);

                estadisticas.add(estadistica);
            }
            result.setEstadisticas(estadisticas);
            dto.setResultado(result);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Consulta construirConsulta() {
        Consulta consulta = new ConsultaComportamiento();
        return consulta;
    }

    @Override
    public String consultar(Consulta consulta) {
        String a = consulta.agregar("");
        System.out.println(a);
        a = a.replaceAll(" ","%20");

        Conexion conexion = new Conexion();
        try {
            String consult = "https://villalobosmartinezjosedavid.000webhostapp.com/consultas/consulta.php?valor="+a;
            String resp = conexion.execute(consult,"GET").get ();
            return resp;
            //Toast.makeText(getApplication(),resp,Toast.LENGTH_LONG).show();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Error";
    }

    public String consultarIndicador(Consulta consulta,String indicador) {
        String a = consulta.agregar(indicador);
        System.out.println(a);
        a = a.replaceAll(" ","%20");

        Conexion conexion = new Conexion();
        try {
            String consult = "https://villalobosmartinezjosedavid.000webhostapp.com/consultas/consulta.php?valor="+a;
            String resp = conexion.execute(consult,"GET").get ();
            return resp;
            //Toast.makeText(getApplication(),resp,Toast.LENGTH_LONG).show();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Error";
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

}
