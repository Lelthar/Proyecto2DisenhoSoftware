<?php
define('DB_HOST','localhost');
define('DB_NAME','id7717372_crash');
define('DB_USER','id7717372_crashadmin');
define('DB_PASSWORD','123456');

class DB {

    private static $db = null;
    private static $pdo;

    final private function __construct() {
        try {
            self::getDB();
        } catch (PDOException $e) {

        }
    }

    public static function getInstance() {
        if (self::$db === null) {
            self::$db = new self();
        }
        return self::$db;
    }

    public function getDB() {
        if (self::$pdo == null) {
            self::$pdo = new PDO(
                'mysql:dbname=' . DB_NAME . ';host=' . DB_HOST . ';',
                DB_USER, DB_PASSWORD,
                array(PDO::MYSQL_ATTR_INIT_COMMAND => "SET NAMES utf8")
            );
            self::$pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
        }
        return self::$pdo;
    }

    final protected function __clone() {

    }

    function _destructor() {
        self::$pdo = null;
    }
}
?>
