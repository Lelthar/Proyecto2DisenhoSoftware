package com.example.marlon_pc.projectdesign2.Controlador;

import java.util.concurrent.ExecutionException;

public class DaoBaseDatos {
    private String consulta;
    private String resultado;
    private String metodo;

    public DaoBaseDatos(String consulta,String metodo) {
        this.consulta = consulta;
        this.metodo = metodo;
        this.resultado = "";
    }

    public String getConsulta() {
        return consulta;
    }

    public void setConsulta(String consulta) {
        this.consulta = consulta;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public String getMetodo() {
        return metodo;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }

    public boolean enviarConsulta(){
        Conexion conexion = new Conexion();
        try {
            this.resultado = conexion.execute(this.consulta,this.metodo).get();
            return true;
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return false;
    }
}
