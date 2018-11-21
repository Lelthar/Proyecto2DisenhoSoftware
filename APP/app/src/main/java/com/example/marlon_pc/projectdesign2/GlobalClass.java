package com.example.marlon_pc.projectdesign2;

import java.util.regex.Pattern;

public class GlobalClass {

    /**
     * Espacio de valores constantes del programa.
     */
    /* Expresiones regulares para validar entradas de formulario de registro de usuario */
    public static final Pattern PATTERN_LETTERS = Pattern.compile("[a-zA-ZáéíóúñÁÉÍÓÚÑ ]+");
    public static final Pattern PATTERN_ALPHA_NUM = Pattern.compile("[a-zA-ZáéíóúñÁÉÍÓÚÑ]+[0-9]*");
    public static final Pattern PATTERN_PASSWORD = Pattern.compile("[a-zA-ZáéíóúñÁÉÍÓÚÑ]+[0-9]+");
    public static final Pattern PATTERN_EMAIL = Pattern.compile("^[\\w-+]+(\\.[\\w-]{1,62}){0,126}@[\\w-]{1,63}(\\.[\\w-]{1,62})");
    public static final Pattern PATTERN_PHONE = Pattern.compile("(8|7|6){1}[0-9]{7}");

    /*Strings utilizados para el servicio de Watson*/
    public static final String MODELO = "380a0fde-98bc-41a1-9f72-bab7277baf97";
    public static final String VERSION= "2018-03-16";
    public static final String AUTENTIFICACION= "Basic YmViMTEyOWQtNGYzYi00ZmJjLWE4YzUtNzQ5ODdkZTdkZmMzOmsxWUpYblVLQXlSTw==";

    /* Direcciones PHP de host remoto */
    public static final String URL_HOST = "https://villalobosmartinezjosedavid.000webhostapp.com/";

    /* Links PHP de tabla de indicadores  */
    public static final String ALL_VALOR = URL_HOST + "valores/getAll";
    public static final String ALL_PROVINCIAS = URL_HOST + "valores/getAllProvincias.php";
    public static final String All_CANTONES = URL_HOST + "valores/getAllCantones.php";
    public static final String All_DISTRITOS = URL_HOST + "valores/getAllDistritos.php";
    public static final String All_ANHOS = URL_HOST + "valores/getAllAnhos.php";
    public static final String All_MESES = URL_HOST + "valores/getAllMeses.php";
    public static final String All_DIAS = URL_HOST + "valores/getAllDias.php";
    public static final String All_SEXOS = URL_HOST + "valores/getAllSexos.php";
    public static final String All_LESIONES = URL_HOST + "valores/getAllLesiones.php";
    public static final String All_ROLES = URL_HOST + "valores/getAllRoles.php";

    public static final String GET_CONSULTA = URL_HOST + "consultas/consulta.php";
}

