<?php 

include "Conexion.php";

if((!empty($_POST['id_cuestionario'])) || (!empty($_GET['id_cuestionario']))) {
    $id_cuestionario = (!empty($_POST['id_cuestionario']))? $_POST['id_cuestionario'] : $_GET['id_cuestionario'];

    $consulta_respuestas = $base_de_datos->prepare("SELECT preguntas.*, respuestas.respuesta, respuestas.estado FROM preguntas JOIN respuestas ON preguntas.id = respuestas.id_pregunta WHERE respuestas.id_cuestionario = :ic");

    $consulta_respuestas->bindParam(":ic", $id_cuestionario);
    $consulta_respuestas->execute();

    $respuestas = $consulta_respuestas->fetchAll(PDO::FETCH_ASSOC);

    if ($respuestas) {
        foreach ($respuestas as $respuesta) {
            $consulta_opciones = $base_de_datos->prepare("SELECT opciones.* FROM opciones JOIN preguntas ON opciones.id_pregunta = preguntas.id WHERE opciones.id_pregunta = :ip");

            $consulta_opciones->bindParam("ip", $respuesta['id']);
            $consulta_opciones->execute();

            $opciones = $consulta_opciones->fetchAll(PDO::FETCH_ASSOC);

            $respuestasArray[] = [
                "pregunta" => $respuesta,
                "opciones" => $opciones
            ];
        }

        $respuesta = [
            "status" => true,
            "message" => "OK##PROCESS",
            "respuestas" => $respuestasArray
        ];
        echo json_encode($respuesta);
    } else {
        $respuesta = [
            "status" => false,
            "message" => "ERROR##PROCESS"
        ];
        echo json_encode($respuesta);
    }
} else {
    $respuesta = [
        "status" => false,
        "message" => "ERROR##DATOS"
    ];
    echo json_encode($respuesta);
}

?>