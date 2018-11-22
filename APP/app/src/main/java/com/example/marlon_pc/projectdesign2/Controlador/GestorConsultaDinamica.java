package com.example.marlon_pc.projectdesign2.Controlador;

import android.util.Log;
import android.widget.Switch;
import android.widget.Toast;

import com.example.marlon_pc.projectdesign2.Modelo.Anho;
import com.example.marlon_pc.projectdesign2.Modelo.Canton;
import com.example.marlon_pc.projectdesign2.Modelo.Consulta;
import com.example.marlon_pc.projectdesign2.Modelo.ConsultaDinamica;
import com.example.marlon_pc.projectdesign2.Modelo.Dia;
import com.example.marlon_pc.projectdesign2.Modelo.Distrito;
import com.example.marlon_pc.projectdesign2.Modelo.Edad;
import com.example.marlon_pc.projectdesign2.Modelo.Entidad;
import com.example.marlon_pc.projectdesign2.Modelo.Lesion;
import com.example.marlon_pc.projectdesign2.Modelo.Mes;
import com.example.marlon_pc.projectdesign2.Modelo.Provincia;
import com.example.marlon_pc.projectdesign2.Modelo.Rol;
import com.example.marlon_pc.projectdesign2.Modelo.Sexo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.ExecutionException;

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
                Consulta consul = construirConsulta();
                String valores = consultar(consul);

                if(!valores.equals("Error")){
                    //System.out.println(valores);
                    /*
                    try {
                        JSONObject JsonObjecto = new JSONObject(valores);
                        String cantidadJson = JsonObjecto.getString("value");

                        JSONArray datos = new JSONArray(cantidadJson);
                        int cantidad = Integer.parseInt(datos.getJSONObject(0).getString("COUNT(*)"));

                        System.out.println(cantidad);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    */
                }else{
                    return "Problema BD";
                }

            }
            //Log.i("Lista Valores:",gestorEntidades.toString());
        }else{
            return "Problema Watson";
        }
        return "";
    }

    @Override
    public Consulta construirConsulta() {
        ArrayList<Entidad> lista = gestorEntidades.getListaEntidades();
        Collections.reverse(lista);
        Consulta con = null;
        boolean state = false;
        boolean ultimo = false;
        String anterior = "";
        int cont =0;
        for(Entidad entidad : lista){

            if(cont == lista.size()-1){
                ultimo=true;
            }
            cont++;
            switch (entidad.getTipo()){
                case "Provincia":
                    if(state){
                        if(anterior.equals(entidad.getTipo())){
                            con = new Provincia(entidad.getValor(),"1",con);
                            anterior = entidad.getTipo();
                        }else{
                            con = new Provincia(entidad.getValor(),"2",con);
                            anterior = entidad.getTipo();
                        }
                    }else{
                        con = new Provincia(entidad.getValor(),"0",new ConsultaDinamica());
                        anterior=entidad.getTipo();
                        state=true;
                    }
                    break;
                case "Cantones":
                    if(state){
                        if(anterior.equals(entidad.getTipo())){
                            System.out.println(anterior+" "+entidad.getTipo());
                            con = new Canton(entidad.getValor(),"1",con);
                            anterior = entidad.getTipo();
                        }else{
                            con = new Canton(entidad.getValor(),"2",con);
                            anterior = entidad.getTipo();
                        }

                    }else{
                        con = new Canton(entidad.getValor(),"0",new ConsultaDinamica());
                        state=true;
                        anterior=entidad.getTipo();
                    }
                    break;
                case "Distritos":
                    if(state){
                        if(anterior.equals(entidad.getTipo())){
                            con = new Distrito(entidad.getValor(),"1",con);
                            anterior = entidad.getTipo();
                        }else{
                            con = new Distrito(entidad.getValor(),"2",con);
                            anterior = entidad.getTipo();
                        }

                    }else{
                        con = new Distrito(entidad.getValor(),"0",new ConsultaDinamica());
                        state=true;
                        anterior=entidad.getTipo();
                    }
                    break;
                case "Anho":
                    if(state){
                        if(anterior.equals(entidad.getTipo())){
                            System.out.println(anterior+" "+entidad.getTipo());
                            con = new Anho(entidad.getValor(),"1",con);
                            anterior = entidad.getTipo();
                        }else{
                            con = new Anho(entidad.getValor(),"2",con);
                            anterior = entidad.getTipo();
                        }

                    }else{
                        con = new Anho(entidad.getValor(),"0",new ConsultaDinamica());
                        state=true;
                        anterior=entidad.getTipo();
                    }
                    break;
                case "Mes":
                    if(state){
                        if(anterior.equals(entidad.getTipo())){
                            con = new Mes(entidad.getValor(),"1",con);
                            anterior = entidad.getTipo();
                        }else{
                            con = new Mes(entidad.getValor(),"2",con);
                            anterior = entidad.getTipo();
                        }

                    }else{
                        con = new Mes(entidad.getValor(),"0",new ConsultaDinamica());
                        state=true;
                        anterior=entidad.getTipo();
                    }
                    break;
                case "Dia":
                    if(state){
                        if(anterior.equals(entidad.getTipo())){
                            con = new Dia(entidad.getValor(),"1",con);
                            anterior = entidad.getTipo();
                        }else{
                            con = new Dia(entidad.getValor(),"2",con);
                            anterior = entidad.getTipo();
                        }

                    }else{
                        con = new Dia(entidad.getValor(),"0",new ConsultaDinamica());
                        state=true;
                        anterior=entidad.getTipo();
                    }
                    break;
                case "Rol":
                    if(state){
                        if(anterior.equals(entidad.getTipo())){
                            con = new Rol(entidad.getValor(),"1",con);
                            anterior = entidad.getTipo();
                        }else{
                            con = new Rol(entidad.getValor(),"2",con);
                            anterior = entidad.getTipo();
                        }

                    }else{
                        con = new Rol(entidad.getValor(),"0",new ConsultaDinamica());
                        state=true;
                        anterior=entidad.getTipo();
                    }
                    break;
                case "Genero":
                    if(state){
                        if(anterior.equals(entidad.getTipo())){
                            con = new Sexo(entidad.getValor(),"1",con);
                            anterior = entidad.getTipo();
                        }else{
                            con = new Sexo(entidad.getValor(),"2",con);
                            anterior = entidad.getTipo();
                        }

                    }else{
                        con = new Sexo(entidad.getValor(),"0",new ConsultaDinamica());
                        state=true;
                        anterior=entidad.getTipo();
                    }
                    break;
                case "TipoLesion":
                    if(state){
                        if(anterior.equals(entidad.getTipo())){
                            con = new Lesion(entidad.getValor(),"1",con);
                            anterior = entidad.getTipo();
                        }else{
                            con = new Lesion(entidad.getValor(),"2",con);
                            anterior = entidad.getTipo();
                        }

                    }else{
                        con = new Lesion(entidad.getValor(),"0",new ConsultaDinamica());
                        state=true;
                        anterior=entidad.getTipo();
                    }
                    break;
                case "Edad":
                    if(state){
                        if(anterior.equals(entidad.getTipo())){
                            con = new Edad(entidad.getValor(),"1",con);
                            anterior = entidad.getTipo();
                        }else{
                            con = new Edad(entidad.getValor(),"2",con);
                            anterior = entidad.getTipo();
                        }

                    }else{
                        con = new Edad(entidad.getValor(),"0",new ConsultaDinamica());
                        state=true;
                        anterior = entidad.getTipo();
                    }
                    break;
            }
        }
        return con;
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
            System.out.println(resp);
            return resp;
            //Toast.makeText(getApplication(),resp,Toast.LENGTH_LONG).show();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Error";
    }


    public boolean validar(){
        return true;
    }
}
