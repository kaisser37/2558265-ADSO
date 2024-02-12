package com.example.pokeconsumo;

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

public class AdaptadorPokemon extends RecyclerView.Adapter<AdaptadorPokemon.ViewHolder> {

    List<Pokemon> listaPokemon;

    public AdaptadorPokemon(List<Pokemon> listaPersonas){
        this.listaPokemon = listaPokemon;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Se crea la carta
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pokemon, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // aqui se asigna los datos dentro de cada carta
        Persona temp = listaPersonas.get(position);
        holder.cargarDatos(temp);

    }

    @Override
    public int getItemCount() {
        return listaPersonas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView etqNombres;
        TextView etqEdad;
        FloatingActionButton btn_buscar;

        Context contexto;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            etqNombres = itemView.findViewById(R.id.etqNombres);
            etqEdad = itemView.findViewById(R.id.etqEdad);
            btn_buscar = itemView.findViewById(R.id.btn_buscar);

            contexto = itemView.getContext();

        }

        public void cargarDatos(Persona persona){
            etqNombres.setText(persona.getNombres());
            etqEdad.setText(persona.getEdad());


        }

    }
}
