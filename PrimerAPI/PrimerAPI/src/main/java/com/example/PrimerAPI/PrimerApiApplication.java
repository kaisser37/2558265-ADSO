package com.example.PrimerAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class PrimerApiApplication {

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
            Persona temporal = new Persona ("1088", "Santi", "Vergara", "3156873364","santi@gmai.com");
            return temporal;
        }
}
