package com.example.primeraplicacion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText campo_id;
    EditText campo_nombre;
    EditText campo_email;

    Button btn_registrar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        campo_id=findViewById(R.id.campo_id);
        campo_nombre=findViewById(R.id.campo_nombre);
        campo_email=findViewById(R.id.campo_email);
        btn_registrar=findViewById(R.id.btn_registrar);

    }

    public void registarPersona(View vista){
        String id = campo_id.getText().toString();
        String nombre = campo_nombre.getText().toString();
        String email = campo_email.getText().toString();

        System.out.println("Id:" + id);
        System.out.println("Nombre:" + nombre);
        System.out.println("Email:" + email);
    }
}