package principal;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.HashMap;
import java.util.Map;

public class Principal {

    public static void main(String[] args) {
        
        ListaPersonas ventana = new ListaPersonas();

        ConsumoAPI ejemplo = new ConsumoAPI();

        // GET sin datos
        System.out.println("Consumo GET: " + ejemplo.consumoGET("http://localhost/APIenPHP_JAVA/Obtener.php"));
        String respuesta = ejemplo.consumoGET("http://localhost/APIenPHP_JAVA/Obtener.php");

        if (respuesta != null) {
            // Analiza la respuesta JSON
            JsonParser parser = new JsonParser();
            JsonObject jsonObject = parser.parse(respuesta).getAsJsonObject();

            // Asume que la respuesta contiene un arreglo llamado "registros"
            JsonArray registros = jsonObject.getAsJsonArray("registros");

            // Itera a través de los registros y muestra sus datos en la consola
            for (int i = 0; i < registros.size(); i++) {
                JsonObject registro = registros.get(i).getAsJsonObject();
                String nombre = registro.get("nombres").getAsString();
                String apellido = registro.get("apellidos").getAsString();
                String telefono = registro.get("telefono").getAsString();

                System.out.println("Nombre: " + nombre);
                System.out.println("Apellido: " + apellido);
                System.out.println("Telefono: " + telefono);
                System.out.println();
            }
        } else {
            System.out.println("No se pudo obtener respuesta en el consumoGET de obtener personas");
        }

        // GET con Datos
        Map<String, String> getData = new HashMap<>();
        getData.put("cedula", "108804");
        System.out.println("Consumo SELECT: " + ejemplo.consumoGET("http://localhost/APIenPHP_JAVA/getPersona.php", getData));
        String respuestaGetDatos = ejemplo.consumoGET("http://localhost/APIenPHP_JAVA/getPersona.php", getData);

        if (respuestaGetDatos != null) {
            JsonParser parser = new JsonParser();
            JsonObject jsonObject = parser.parse(respuestaGetDatos).getAsJsonObject();

            String nombre = jsonObject.get("nombres").getAsString();
            String apellido = jsonObject.get("apellidos").getAsString();
            String telefono = jsonObject.get("telefono").getAsString();
            
            System.out.println("Usuario obteneido con la cedula usando el metodo get");
            System.out.println("Nombre: " + nombre);
            System.out.println("Apellido: " + apellido);
            System.out.println("Telefono: " + telefono);
            System.out.println();
        } else {
            System.out.println("No existe un usuario con ese número de cédula");
        }

        // POST con Datos
        Map<String, String> insertData = new HashMap<>();
        insertData.put("cedula", "102200");
        insertData.put("nombres", "Oscar JAVA");
        insertData.put("apellidos", "Loaiza JAVA");
        insertData.put("telefono", "333333333");
        insertData.put("direccion", "Calle 20");
        insertData.put("email", "oscar@mail.com");
        System.out.println("Consumo INSERT: " + ejemplo.consumoPOST("http://localhost/APIenPHP_JAVA/Insert.php", insertData));

        // POST con Datos
        Map<String, String> updateData = new HashMap<>();
        updateData.put("cedula", "102200");
        updateData.put("nombres", "Oscar JAVA UPDATE");
        updateData.put("apellidos", "Loaiza JAVA UPDATE");
        updateData.put("telefono", "333333");
        updateData.put("direccion", "Calle 20");
        updateData.put("email", "oscar@mail.com");
        System.out.println("Consumo UPDATE: " + ejemplo.consumoPOST("http://localhost/APIenPHP_JAVA/Update.php", updateData));

        // POST con Datos
        Map<String, String> deleteData = new HashMap<>();
        deleteData.put("cedula", "102200");
        System.out.println("Consumo DELETE: " + ejemplo.consumoPOST("http://localhost/APIenPHP_JAVA/Delete.php", deleteData));

    }
}
