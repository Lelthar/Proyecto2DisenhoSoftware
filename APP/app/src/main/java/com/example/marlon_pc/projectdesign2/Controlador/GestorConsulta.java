package com.example.marlon_pc.projectdesign2.Controlador;

import com.example.marlon_pc.projectdesign2.Modelo.Consulta;

public interface GestorConsulta {

    public String efectuarConsulta(DTOConsulta dto);

    public Consulta construirConsulta();

    public String consultar(Consulta consulta);

}
