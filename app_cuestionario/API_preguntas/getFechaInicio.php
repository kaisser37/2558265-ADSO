<?php 

include "Conexion.php";

if( (!empty($_POST['id_cuestionario'])) || (!empty($_GET['id_cuestionario'])) ) {
    $id_cuestionario = (!empty($_POST['id_cuestionario']))? $_POST['id_cuestionario'] : $_GET['id_cuestionario'];

    $consulta = $base_de_datos->prepare("SELECT * FROM cuestionarios WHERE id = :ic");
    $consulta->bindParam(":ic", $id_cuestionario);
    $consulta->execute();

    $cuestionario = $consulta->fetchAll(PDO::FETCH_ASSOC);

    if($cuestionario) {
        $respuesta = [
            "status" => true,
            "message" => "OK##PROCESS",
            "cuestionario" => $cuestionario
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