package com.example.prubarecycler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText campoBusqueda;
    FloatingActionButton btn_buscar;
    RecyclerView recyclerPersonas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        campoBusqueda=findViewById(R.id.campo_busqueda);
        btn_buscar=findViewById(R.id.btn_buscar);
        recyclerPersonas=findViewById(R.id.recyclerPersonas);

        List<Persona> listaPersona = new ArrayList<>();
        listaPersona.add(new Persona("Winder","19","MASCULINO","321888665","winderroman3131@gmail.com","ACTIVO"));
        listaPersona.add(new Persona("Ana Perez","30","FEMENINO","310789233","anaperez@gmail.com","INACTIVO"));


        recyclerPersonas.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        AdaptadorPersonas adaptador = new AdaptadorPersonas(listaPersona);
        recyclerPersonas.setAdapter(adaptador);

    }



}