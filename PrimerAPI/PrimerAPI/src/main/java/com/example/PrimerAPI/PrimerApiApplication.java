package com.example.PrimerAPI;

import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.PrimerAPI.DataBase;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;
     
@SpringBootApplication
@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST} )
public class PrimerApiApplication {
    
        DataBase db;
        
        public PrimerApiApplication(){
            db = new DataBase();
        }

	public static void main(String[] args) {
		SpringApplication.run(PrimerApiApplication.class, args);
	}
        @GetMapping("/")
        public String inicio(){
            String parte01 = "HOLA";
            String parte02 = "WORLD";
            return parte01+" "+parte02;
        }
        
        @GetMapping("/persona")
        public Persona prueba (){
            Persona temporal = new Persona ("1088", "Santi", "Vergara", "micasa","3156873364","santi@gmail.com");
            return temporal;
        }
        
        @GetMapping("/listapersona")
        public List<Persona> listado(){
            List <Persona> listado = new ArrayList<>();
            ResultSet resultados = db.listaPersonas();
            
            if (resultados!= null){
                try{
                    while(resultados.next()){
                        String cedula = resultados.getString("cedula");
                        String nombre = resultados.getString("nombres");
                        String apellidos = resultados.getString("apellidos");
                        String direccion = resultados.getString("direccion");
                        String telefono = resultados.getString("telefono");
                        String email = resultados.getString("email");

                        Persona persona = new Persona (cedula,nombre,apellidos,direccion,telefono,email); 
                        listado.add(persona);
                    }

                }catch (SQLException e){
                    System.out.println("No Funco!!!");
                }



            }
            return listado;
        }
        
        @GetMapping("/getpersona")
        public String getPersona(@RequestParam String cedula){
            
            return "La persona buscada es: "+cedula;
        }
}


    //            List<Persona> listado = new ArrayList<>();
    //            for (int i = 0; i < 9; i++) {
    //                Persona temporal = new Persona ("1088"+i, "nombre0"+i, "apellido0"+i, "telefono0"+i,"email0"+i);
    //                listado.add(temporal);
