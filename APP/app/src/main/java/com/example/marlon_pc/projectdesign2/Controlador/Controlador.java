package com.example.marlon_pc.projectdesign2.Controlador;

public class Controlador {
    private GestorConsultaDinamica gestorConsultaDinamica;
    private GestorConsultaComportamiento gestorConsultaComportamiento;

    public Controlador() {
        this.gestorConsultaDinamica = new GestorConsultaDinamica();
        this.gestorConsultaComportamiento = new GestorConsultaComportamiento();
    }

    public GestorConsultaDinamica getGestorConsultaDinamica() {
        return gestorConsultaDinamica;
    }

    public void setGestorConsultaDinamica(GestorConsultaDinamica gestorConsultaDinamica) {
        this.gestorConsultaDinamica = gestorConsultaDinamica;
    }

    public GestorConsultaComportamiento getGestorConsultaComportamiento() {
        return gestorConsultaComportamiento;
    }

    public void setGestorConsultaComportamiento(GestorConsultaComportamiento gestorConsultaComportamiento) {
        this.gestorConsultaComportamiento = gestorConsultaComportamiento;
    }

    /**
     * Metodo que recibe la solicitud de consulta
     * @param dto
     * @return
     */
    public void enviarConsulta(DTOConsulta dto){
        switch (dto.getTipo()){
            case "Dinamica":
                gestorConsultaDinamica.efectuarConsulta(dto);
                break;
            case "Comportamiento":
                gestorConsultaComportamiento.efectuarConsulta(dto);
                break;
            case "Vacaciones":

                break;
             default:
                 break;
        }
    }
}