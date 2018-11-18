<?php
require 'ClassConnection.php';

class Indicadores {
    function __construct() {

    }

    /* __________ READS _____________________________________________________ */
    /* Obtiene todas las Provincias */
    public static function getAllProvincias() {
        $query = "SELECT nombreProvincia
                  FROM Provincia";
        $command = DB::getInstance()->getDB()->prepare($query);
        $command->execute();
        return $command->fetchAll(PDO::FETCH_ASSOC);
    }

    /* Obtiene todas las Cantones */
    public static function getAllCantones() {
        $query = "SELECT nombreCanton
                  FROM Canton";
        $command = DB::getInstance()->getDB()->prepare($query);
        $command->execute();
        return $command->fetchAll(PDO::FETCH_ASSOC);
    }

    /* Obtiene todas las Distritos */
    public static function getAllDistritos() {
        $query = "SELECT nombreDistrito
                  FROM Distrito";
        $command = DB::getInstance()->getDB()->prepare($query);
        $command->execute();
        return $command->fetchAll(PDO::FETCH_ASSOC);
    }

    /* Obtiene todas las Años */
    public static function getAllAnhos() {
        $query = "SELECT nombreAnho
                  FROM Anho";
        $command = DB::getInstance()->getDB()->prepare($query);
        $command->execute();
        return $command->fetchAll(PDO::FETCH_ASSOC);
    }

    /* Obtiene todas las Mes */
    public static function getAllMeses() {
        $query = "SELECT nombreMes
                  FROM Mes";
        $command = DB::getInstance()->getDB()->prepare($query);
        $command->execute();
        return $command->fetchAll(PDO::FETCH_ASSOC);
    }

    /* Obtiene todas las Dias */
    public static function getAllDias() {
        $query = "SELECT nombreDia
                  FROM Dia";
        $command = DB::getInstance()->getDB()->prepare($query);
        $command->execute();
        return $command->fetchAll(PDO::FETCH_ASSOC);
    }

    /* Obtiene todas las sexos */
    public static function getAllSexos() {
        $query = "SELECT nombreSexo
                  FROM Sexo";
        $command = DB::getInstance()->getDB()->prepare($query);
        $command->execute();
        return $command->fetchAll(PDO::FETCH_ASSOC);
    }

    /* Obtiene todas las lesiones */
    public static function getAllLesiones() {
        $query = "SELECT nombreLesion
                  FROM Lesion";
        $command = DB::getInstance()->getDB()->prepare($query);
        $command->execute();
        return $command->fetchAll(PDO::FETCH_ASSOC);
    }

    /* Obtiene todas los Roles */
    public static function getAllRoles() {
        $query = "SELECT nombreRol
                  FROM Rol";
        $command = DB::getInstance()->getDB()->prepare($query);
        $command->execute();
        return $command->fetchAll(PDO::FETCH_ASSOC);
    }
}
?>
