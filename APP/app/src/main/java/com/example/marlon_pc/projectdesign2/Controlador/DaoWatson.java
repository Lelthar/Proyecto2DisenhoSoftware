package com.example.marlon_pc.projectdesign2.Controlador;

import android.util.Log;

import java.util.concurrent.ExecutionException;

public class DaoWatson {
    private String version;
    private String texto;
    private String modelo;
    private String autentificacion;
    private String resultado;

    public DaoWatson(String version, String texto, String modelo, String autentificacion) {
        this.version = version;
        this.texto = texto;
        this.modelo = modelo;
        this.autentificacion = autentificacion;
        this.resultado = "";
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAutentificacion() {
        return autentificacion;
    }

    public void setAutentificacion(String autentificacion) {
        this.autentificacion = autentificacion;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public boolean enviarDatos(){
        ConexionWatson conexionWatson = new ConexionWatson();
        String dirConsulta = "https://gateway.watsonplatform.net/natural-language-understanding/api/v1/analyze?version="
                +this.version+"&text="
                +this.texto+"&features=entities&return_analyzed_text=false&clean=true&fallback_to_raw=true&concepts.limit" +
                "=8&emotion.document=true&entities.limit=50&entities.mentions=false&entities.model="
                +this.modelo+"&entities.emotion=false&entities.sentiment=false&keywords.limit=50&keywords.emotion=false&" +
                "keywords.sentiment=false&relations.model=en-news&semantic_roles.limit=50&semantic_roles.entities=false&" +
                "semantic_roles.keywords=false&sentiment.document=true";
        try {
            this.resultado = conexionWatson.execute(dirConsulta,"GET",this.autentificacion).get();
            return true;
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return false;
    }
}
