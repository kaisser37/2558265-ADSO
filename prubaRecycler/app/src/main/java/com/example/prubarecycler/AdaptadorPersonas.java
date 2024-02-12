package com.example.prubarecycler;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class AdaptadorPersonas extends RecyclerView.Adapter<AdaptadorPersonas.ViewHolder> {

    List<Persona> listaPersonas;

    public AdaptadorPersonas(List<Persona> listaPersonas){
        this.listaPersonas = listaPersonas;
    }


    @NonNull
    @Override
    public AdaptadorPersonas.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Se crea la carta
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_personas, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorPersonas.ViewHolder holder, int position) {
        // aqui se asigna los datos dentro de cada carta
        Persona temp = listaPersonas.get(position);
        holder.cargarDatos(temp);

    }

    @Override
    public int getItemCount() {
        return listaPersonas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPersona;
        TextView etqNombres;
        TextView etqEdad;
        TextView etqGenero;
        TextView etqTelefono;
        TextView etqEmail;
        TextView etqEstado;
        FloatingActionButton btn_buscar;

        Context contexto;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgPersona = itemView.findViewById(R.id.imgPersona);
            etqNombres = itemView.findViewById(R.id.etqNombres);
            etqEdad = itemView.findViewById(R.id.etqEdad);
            etqGenero = itemView.findViewById(R.id.etqGenero);
            etqTelefono = itemView.findViewById(R.id.etqTelefono);
            etqEmail = itemView.findViewById(R.id.etqEmail);
            etqEstado = itemView.findViewById(R.id.etqEstado);
            btn_buscar = itemView.findViewById(R.id.btn_buscar);

            contexto = itemView.getContext();

        }

        public void cargarDatos(Persona persona){
            etqNombres.setText(persona.getNombres());
            etqEdad.setText(persona.getEdad());
            etqGenero.setText(persona.getGenero());
            etqTelefono.setText(persona.getTelefono());
            etqEmail.setText(persona.getEmail());
            etqEstado.setText(persona.getEstado());

            if (persona.getEstado().equalsIgnoreCase("ACTIVO")){
                etqEstado.setTextColor(Color.GREEN);
            }else{
                etqEstado.setTextColor(Color.RED);
            }

            if (persona.getGenero().equalsIgnoreCase("MASCULINO")){
                imgPersona.setImageResource(R.mipmap.ic_masculino);
            }else{
                imgPersona.setImageResource(R.mipmap.ic_femenino);
            }

            btn_buscar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String nombres = persona.getNombres();
                    String edad = persona.getEdad();
                    String genero = persona.getGenero();
                    String telefono = persona.getTelefono();
                    String email = persona.getEmail();
                    String estado = persona.getEstado();

                    Intent intent = new Intent(contexto, DetallePersona.class);
                    intent.putExtra("nombres",nombres);
                    intent.putExtra("telefono",telefono);
                    intent.putExtra("edad",edad);
                    intent.putExtra("genero",genero);
                    intent.putExtra("email",email);
                    intent.putExtra("estado",estado);

                    contexto.startActivity(intent);


                }
            });

        }

    }
}
