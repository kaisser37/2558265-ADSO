package com.example.primeraplicacion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.primera_pregunta);

    }

    public void registrarPersona(View vista){


        String pregunta1 = pregunta1.getText().toString();
        String pregunta2 = campo_nombre.getText().toString();
        String email = campo_email.getText().toString();

        Intent intencion = new Intent( this, SegundaActividad.class );
        intencion.putExtra("id", id);
        intencion.putExtra("nombres", nombre);
        intencion.putExtra("email", email);
        startActivity(intencion);


    }
}