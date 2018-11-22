package com.example.marlon_pc.projectdesign2.Controlador;

import android.util.Log;

import com.example.marlon_pc.projectdesign2.GlobalClass;
import com.example.marlon_pc.projectdesign2.Modelo.Consulta;
import com.example.marlon_pc.projectdesign2.Modelo.ConsultaVacaciones;
import com.example.marlon_pc.projectdesign2.Modelo.Entidad;
import com.example.marlon_pc.projectdesign2.Modelo.Observador;
import com.example.marlon_pc.projectdesign2.Modelo.Periodo;
import com.example.marlon_pc.projectdesign2.Modelo.Resultado;
import com.example.marlon_pc.projectdesign2.Modelo.ResultadoConsultaVacaciones;
import com.example.marlon_pc.projectdesign2.Modelo.ResultadoConsultaVacaciones;
import com.example.marlon_pc.projectdesign2.Modelo.Sujeto;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
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


        Sujeto sujeto = dto.getSujeto();


        String consulta1 =  "SELECT count(*) " +
                "FROM IncidenteCompleto IC " +
                "WHERE IC.nombreAnho = '2012' AND (IC.nombreMes = 'Diciembre' or IC.nombreMes = 'Enero')" ;

        String consulta2 =  "SELECT count(*) " +
                " FROM IncidenteCompleto IC " +
                "WHERE IC.nombreAnho = '2013' AND (IC.nombreMes = 'Diciembre' or IC.nombreMes = 'Enero') ";

        String consulta3 = "SELECT count(*) " +
                "FROM IncidenteCompleto IC " +
                "WHERE IC.nombreAnho = '2014' AND" +
                "(IC.nombreMes = 'Diciembre' or IC.nombreMes = 'Enero')" ;

        String consulta4 = "SELECT count(*) " +
                "FROM IncidenteCompleto IC " +
                "WHERE IC.nombreAnho = '2012' AND" +
                "(IC.nombreMes = 'Julio' or IC.nombreMes = 'Junio')" ;

        String consulta5 = "SELECT count(*) " +
                "FROM IncidenteCompleto IC " +
                "WHERE IC.nombreAnho = '2013' AND" +
                "(IC.nombreMes = 'Julio' or IC.nombreMes = 'Junio')" ;

        String consulta6 = "SELECT count(*) " +
                "FROM IncidenteCompleto IC " +
                "WHERE IC.nombreAnho = '2014' AND " +
                "(IC.nombreMes = 'Julio' or IC.nombreMes = 'Junio')" ;

        String consulta7 = "SELECT count(*) " +
                "FROM IncidenteCompleto IC " +
                "WHERE IC.nombreAnho = '2012' AND " +
                "(IC.nombreMes = 'Abril' or IC.nombreMes = 'Marzo')" ;

        String consulta8 = "SELECT count(*) " +
                "FROM IncidenteCompleto IC " +
                "WHERE IC.nombreAnho = '2013' AND" +
                "(IC.nombreMes = 'Abril' or IC.nombreMes = 'Marzo')" ;

        String consulta9 = "SELECT count(*) " +
                "FROM IncidenteCompleto IC " +
                "WHERE IC.nombreAnho = '2014' AND" +
                "(IC.nombreMes = 'Abril' or IC.nombreMes = 'Marzo')" ;



        consulta1 = consulta1.replaceAll(" ","%20");
        consulta2 = consulta2.replaceAll(" ","%20");
        consulta3 = consulta3.replaceAll(" ","%20");
        consulta4 = consulta4.replaceAll(" ","%20");
        consulta5 = consulta5.replaceAll(" ","%20");
        consulta6 = consulta6.replaceAll(" ","%20");
        consulta7 = consulta7.replaceAll(" ","%20");
        consulta8 = consulta8.replaceAll(" ","%20");
        consulta9 = consulta9.replaceAll(" ","%20");

        Conexion conexion = new Conexion();
        try {

            String consult = "";
            String resp = "" ;
            boolean otro =false;
            ArrayList<String> obs = new ArrayList<>();
            if(sujeto.obs2012 && sujeto.obsVerano){
                obs.add("2012Verano");
                if(otro){
                    consult += " UNION "+consulta1;
                }else{
                    consult += consulta1;
                    otro=true;
                }
            }
            if(sujeto.obs2013 && sujeto.obsVerano){
                obs.add("2013Verano");
                if(otro){
                    consult += " UNION "+consulta2;
                }else{
                    consult += consulta2;
                    otro=true;
                }
            }

            if(sujeto.obs2014 && sujeto.obsVerano){
                obs.add("2014Verano");
                if(otro){
                    consult += " UNION "+consulta3;
                }else{
                    consult += consulta3;
                    otro=true;
                }
            }

            if(sujeto.obs2012 && sujeto.obsMediados){
                obs.add("2012Mediados");
                if(otro){
                    consult += " UNION "+consulta4;
                }else{
                    consult += consulta4;
                    otro=true;
                }

            }

            if(sujeto.obs2013 && sujeto.obsMediados){
                obs.add("2013Mediados");
                if(otro){
                    consult += " UNION "+consulta5;
                }else{
                    consult += consulta5;
                    otro=true;
                }
            }

            if(sujeto.obs2014 && sujeto.obsMediados){
                obs.add("2014Mediados");
                if(otro){
                    consult += " UNION "+consulta6;
                }else{
                    consult += consulta6;
                    otro=true;
                }

            }

            if(sujeto.obs2012 && sujeto.obsSemanaSanta){
                obs.add("2012SemanaSanta");
                if(otro){
                    consult += " UNION "+consulta7;
                }else{
                    consult += consulta7;
                    otro=true;
                }

            }

            if(sujeto.obs2013 && sujeto.obsSemanaSanta){
                obs.add("2013SemanaSanta");
                if(otro){
                    consult += " UNION "+consulta8;
                }else{
                    consult += consulta8;
                    otro=true;
                }

            }
            if(sujeto.obs2014 && sujeto.obsSemanaSanta){
                obs.add("2014SemanaSanta");
                if(otro){
                    consult += " UNION "+consulta9;
                }else{
                    consult += consulta9;
                    otro=true;
                }
            }

            consult = consult.replaceAll(" ","%20");

            consult = "https://villalobosmartinezjosedavid.000webhostapp.com/consultas/consulta.php?valor="+consult;
            resp = conexion.execute(consult,"GET").get ();

            JSONObject JsonObjecto = new JSONObject(resp);
            String cantidadJson = JsonObjecto.getString("value");

            JSONArray datos = new JSONArray(cantidadJson);
            ArrayList<Periodo> periodos = new ArrayList<>();
            for(int i=0;i<datos.length();i++){
                int cantidad = Integer.parseInt(datos.getJSONObject(i).getString("count(*)"));
                periodos.add(new Periodo(obs.get(i),cantidad));
            }

            Resultado resultado = new ResultadoConsultaVacaciones(periodos);

            dto.setResultado(resultado);
            return resp;

            //Toast.makeText(getApplication(),resp,Toast.LENGTH_LONG).show();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return "Error";


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
