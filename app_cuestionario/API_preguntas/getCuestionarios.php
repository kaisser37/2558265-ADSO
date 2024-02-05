<?php 

include "Conexion.php";

if( (!empty($_POST['id_usuario'])) || (!empty($_GET['id_usuario'])) ) {
    $id_usuario = (!empty($_POST['id_usuario']))? $_POST['id_usuario'] : $_GET['id_usuario'];

    $consulta = $base_de_datos->prepare("SELECT * FROM cuestionarios WHERE id_usuario = :id");
    $consulta->bindParam(":id", $id_usuario);
    $consulta->execute();

    $cuestionarios = $consulta->fetchAll(PDO::FETCH_ASSOC);

    if($cuestionarios) {
        $respuesta = [
            "status" => true,
            "message" => "OK##PROCESS",
            "resumen" => $cuestionarios
        ];
        echo json_encode($respuesta);
    } else {
        $respuesta = [
            "status" => false,
            "message" => "ERROR##PROCESS",
        ];
        echo json_encode($respuesta);
    }
    
}else {
    $respuesta = [
        "status" => false,
        "message" => "ERROR##DATOS"
    ];
    echo json_encode($respuesta);
}

?>