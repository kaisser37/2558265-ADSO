package com.example.primeraplicacion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pregunta1);

    }

    public void (View vista){


        String pregunta1 = pregunta1.getText().toString();
        String pregunta2 = pregunta2.getText().toString();
        String pregunta3 = pregunta3.getText().toString();
        String pregunta4 = pregunta4.getText().toString();
        String pregunta5 = pregunta5.getText().toString();
        String pregunta6 = pregunta6.getText().toString();
        String pregunta7 = pregunta7.getText().toString();
        String pregunta8 = pregunta8.getText().toString();
        String pregunta9 = pregunta9.getText().toString();
        String pregunta10 = pregunta10.getText().toString();


        Intent intencion = new Intent( this, Cuestionario.class );
        intencion.putExtra("id", id);
        intencion.putExtra("nombres", nombre);
        intencion.putExtra("email", email);
        startActivity(intencion);


    }
}