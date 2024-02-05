<?php
include "Conexion.php";
session_start();

function obtenerPreguntaAleatoria() {
    global $base_de_datos;

    $preguntasUtilizadas = empty($_SESSION['preguntas_utilizadas']) ? [0] : $_SESSION['preguntas_utilizadas'];

    $consulta = $base_de_datos->query("SELECT preguntas.*
                                       FROM preguntas
                                       WHERE NOT preguntas.id IN (" . implode(",", $preguntasUtilizadas) . ")
                                       ORDER BY RAND()
                                       LIMIT 1");

    return $consulta->fetch(PDO::FETCH_ASSOC);
}

if ((!empty($_POST['id_cuestionario'])) || (!empty($_GET['id_cuestionario']))) {

    if (!isset($_SESSION['preguntas_utilizadas'])) {
        $_SESSION['preguntas_utilizadas'] = [];
    }

    // Verificar si ya se han mostrado todas las preguntas
    $cantidad_total_preguntas = $base_de_datos->query("SELECT COUNT(*) FROM preguntas")->fetchColumn();
    if (count($_SESSION['preguntas_utilizadas']) >= $cantidad_total_preguntas) {
        $respuesta = [
            "status" => false,
            "message" => "ERROR##Todas las preguntas han sido mostradas"
        ];
        $_SESSION['preguntas_utilizadas'] = [];

        header('Content-Type: application/json');
        echo json_encode($respuesta);
        exit;
    }

    // Obtener una pregunta aleatoria que no haya sido utilizada
    do {
        $pregunta = obtenerPreguntaAleatoria();
    } while (in_array($pregunta['id'], $_SESSION['preguntas_utilizadas']));

    // Agregar la pregunta al array de preguntas utilizadas
    $_SESSION['preguntas_utilizadas'][] = $pregunta['id'];

    $consulta_opciones = $base_de_datos->prepare("SELECT opciones.* FROM opciones JOIN preguntas ON opciones.id_pregunta = preguntas.id WHERE opciones.id_pregunta = :ip");
    $consulta_opciones->bindParam("ip", $pregunta['id']);
    $consulta_opciones->execute();
    $opciones = $consulta_opciones->fetchAll(PDO::FETCH_ASSOC);

    $respuesta = [
        "status" => true,
        "message" => "OK##PROCESS",
        "pregunta" => $pregunta,
        "opciones" => $opciones
    ];

    header('Content-Type: application/json');
    echo json_encode($respuesta);
} else {
    $respuesta = [
        "status" => false,
        "message" => "ERROR##DATOS"
    ];
    header('Content-Type: application/json');
    echo json_encode($respuesta);
}
?>
