<?php 
    header("Access-Control-Allow-Origin: *"); // Permite el acceso desde cualquier origen, o usa "http://localhost" si solo quieres permitirlo desde localhost.
    header("Access-Control-Allow-Methods: GET, POST");
    header("Access-Control-Allow-Headers: Content-Type");
    
    include 'Conexion.php';

    if ( (!empty($_POST['id_usuario'])) || (!empty($_GET['id_usuario']))) {

        $id_usuario = (!empty($_POST['id_usuario']))? $_POST['id_usuario'] : $_GET['id_usuario'];

        try {
            $consulta = $base_de_datos->prepare("INSERT INTO cuestionarios (id_usuario) VALUES(:iu)");

            $consulta->bindParam(':iu', $id_usuario);
            $proceso = $consulta->execute();

            if( $proceso ){
                $respuesta = [
                                'status' => true,
                                'message' => "OK##CUESTIONARIO##INSERT",
                                'id_cuestionario' => $base_de_datos->lastInsertId()
                              ];
                echo json_encode($respuesta);
            }else{
                $respuesta = [
                                'status' => false,
                                'message' => "ERROR##CUESTIONARIO##INSERT"
                              ];
                echo json_encode($respuesta);
            }
        } catch (Exception $e) {
            $respuesta = [
                            'status' => false,
                            'message' => "ERROR##SQL",
                            'exception' => $e
                          ];
            echo json_encode($respuesta);
        }
    }else{
        $respuesta = [
                        'status' => false,
                        'message' => "ERROR##DATOS##POST"
                      ];
        echo json_encode($respuesta);
    }
?>