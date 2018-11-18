<?php
require 'Indicadores.php';
if ($_SERVER['REQUEST_METHOD'] == 'GET') {
    try {
        $ret = Indicadores::getAllMeses();
        if ($ret) {
            $data["status"] = "true";
            $data["value"] = $ret;
            print json_encode($data);
        } else {
            print json_encode(array('status'=>'false'));
        }
    } catch (PDOException $e) {
        print json_encode(array('status'=>'false'));
    }
}
?>
