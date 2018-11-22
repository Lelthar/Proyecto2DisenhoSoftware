package com.example.marlon_pc.projectdesign2.Controlador;

import android.util.Log;

import com.example.marlon_pc.projectdesign2.GlobalClass;
import com.example.marlon_pc.projectdesign2.Modelo.Consulta;
import com.example.marlon_pc.projectdesign2.Modelo.ConsultaVacaciones;
import com.example.marlon_pc.projectdesign2.Modelo.Entidad;
import com.example.marlon_pc.projectdesign2.Modelo.Observador;
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


        String consulta1 =  " SELECT count(*) " +
                "FROM IncidenteCompleto IC " +
                "WHERE IC.nombreAnho = '2012' AND (IC.nombreMes = 'Diciembre' or IC.nombreMes = 'Enero')" ;

        String consulta2 =  "SELECT count(*) " +
                " FROM IncidenteCompleto IC " +
                "WHERE IC.nombreAnho = '2013' AND (IC.nombreMes = 'Diciembre' or IC.nombreMes = 'Enero') ";

        String consulta3 = "SELECT count(*) " +
                "FROM IncidenteCompleto IC" +
                "WHERE IC.nombreAnho = '2014' AND" +
                "(IC.nombreMes = 'Diciembre' or IC.nombreMes = 'Enero')" ;

        String consulta4 = "SELECT count(*) " +
                "FROM IncidenteCompleto IC" +
                "WHERE IC.nombreAnho = '2012' AND" +
                "(IC.nombreMes = 'Julio' or IC.nombreMes = 'Junio')" ;

        String consulta5 = "SELECT count(*) " +
                "FROM IncidenteCompleto IC" +
                "WHERE IC.nombreAnho = '2013' AND" +
                "(IC.nombreMes = 'Julio' or IC.nombreMes = 'Junio')" ;

        String consulta6 = "SELECT count(*) " +
                "FROM IncidenteCompleto IC" +
                "WHERE IC.nombreAnho = '2014' AND " +
                "(IC.nombreMes = 'Julio' or IC.nombreMes = 'Junio')" ;

        String consulta7 = "SELECT count(*) " +
                "FROM IncidenteCompleto IC " +
                "WHERE IC.nombreAnho = '2012' AND " +
                "(IC.nombreMes = 'Abril' or IC.nombreMes = 'Marzo')" ;

        String consulta8 = "SELECT count(*) " +
                "FROM IncidenteCompleto IC" +
                "WHERE IC.nombreAnho = '2013' AND" +
                "(IC.nombreMes = 'Abril' or IC.nombreMes = 'Marzo')" ;

        String consulta9 = "SELECT count(*) " +
                "FROM IncidenteCompleto IC" +
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

            String consult;
            String resp = "" ;
            if(sujeto.obs2012 && sujeto.obsVerano){

                consult = "https://villalobosmartinezjosedavid.000webhostapp.com/consultas/consulta.php?valor="+consulta1;
                resp = resp  + conexion.execute(consult,"GET").get ();
                
            }
            else if(sujeto.obs2013 && sujeto.obsVerano){

                consult = "https://villalobosmartinezjosedavid.000webhostapp.com/consultas/consulta.php?valor="+consulta2;
                resp = resp  + conexion.execute(consult,"GET").get ();


            }

            else if(sujeto.obs2014 && sujeto.obsVerano){

                consult = "https://villalobosmartinezjosedavid.000webhostapp.com/consultas/consulta.php?valor="+consulta3;
                resp = resp  + conexion.execute(consult,"GET").get ();
                System.out.println("Respuesta consulta 3 "  + resp);

            }

            else if(sujeto.obs2012 && sujeto.obsMediados){

                consult = "https://villalobosmartinezjosedavid.000webhostapp.com/consultas/consulta.php?valor="+consulta4;
                resp = resp  + conexion.execute(consult,"GET").get ();


            }

            else if(sujeto.obs2013 && sujeto.obsMediados){

                consult = "https://villalobosmartinezjosedavid.000webhostapp.com/consultas/consulta.php?valor="+consulta5;
                resp = resp  + conexion.execute(consult,"GET").get ();


            }

            else if(sujeto.obs2014 && sujeto.obsMediados){

                consult = "https://villalobosmartinezjosedavid.000webhostapp.com/consultas/consulta.php?valor="+consulta6;
                resp = resp  + conexion.execute(consult,"GET").get ();


            }

            else if(sujeto.obs2012 && sujeto.obsSemanaSanta){

                consult = "https://villalobosmartinezjosedavid.000webhostapp.com/consultas/consulta.php?valor="+consulta7;
                resp = resp  + conexion.execute(consult,"GET").get ();


            }

            else if(sujeto.obs2013 && sujeto.obsSemanaSanta){

                consult = "https://villalobosmartinezjosedavid.000webhostapp.com/consultas/consulta.php?valor="+consulta8;
                resp = resp  + conexion.execute(consult,"GET").get ();


            }

            else if(sujeto.obs2014 && sujeto.obsSemanaSanta){

                consult = "https://villalobosmartinezjosedavid.000webhostapp.com/consultas/consulta.php?valor="+consulta9;
                resp = resp  + conexion.execute(consult,"GET").get ();


            }


            System.out.println("Respuesta consulta 3 "  + resp);
            Resultado resultado = new ResultadoConsultaVacaciones(null, resp);
            dto.setResultado(resultado);
            return resp;


            //Toast.makeText(getApplication(),resp,Toast.LENGTH_LONG).show();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
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
