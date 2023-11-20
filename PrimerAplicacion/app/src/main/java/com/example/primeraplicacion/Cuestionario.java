package com.example.primeraplicacion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Cuestionario extends AppCompatActivity {

    TextView etiqueta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pregunta2);

        Bundle datos = getIntent().getExtras();

        etiqueta = findViewById(R.id.etq_titulo2);

        etiqueta.setText(datos.getString("id") + " - " + datos.getString("nombres") + " - " + datos.getString("email"));

    }
}