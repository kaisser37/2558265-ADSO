package com.example.cuestionario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.service.controls.templates.TemperatureControlTemplate;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.cuestionario.utils.Config;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.Map;

public class DetalleCuestionario extends AppCompatActivity {

    TextView etq_nombre_usuario;
    TextView etq_fecha_inicio;
    TextView etq_fecha_fin;
    TextView etq_preguntas;
    TextView etq_correctas;
    TextView etq_incorrectas;
    String id_cuestionario;
    Config dataConfig;
    LinearLayout layoutDetalles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_cuestionario);

        etq_nombre_usuario = findViewById(R.id.etq_nombre_usuario);
        etq_fecha_inicio = findViewById(R.id.etq_fecha_inicio);
        etq_fecha_fin = findViewById(R.id.etq_fecha_fin);
        etq_preguntas = findViewById(R.id.etq_preguntas);
        etq_correctas = findViewById(R.id.etq_correctas);
        etq_incorrectas = findViewById(R.id.etq_incorrectas);

        dataConfig = new Config(getApplicationContext());
        layoutDetalles = findViewById(R.id.layoutDetalles);
        layoutDetalles.setBackgroundColor(getResources().getColor(R.color.light_gray));
        layoutDetalles.setPadding(40, 40, 40, 40);

        FloatingActionButton boton_atras = findViewById(R.id.boton_atras);
        boton_atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intencion = new Intent(getApplicationContext(), ResumenUsuario.class);
                startActivity(intencion);
                finish();
            }
        });

        cargarResumen();
    }

    public void cargarResumen() {
        SharedPreferences archivo = getSharedPreferences("app_preguntas", Context.MODE_PRIVATE);
        String cuestionarioString = archivo.getString("cuestionario_string", null);
        String nombres = archivo.getString("nombres", null);

        try {
            JSONObject cuestionario = new JSONObject(cuestionarioString);

            etq_nombre_usuario.setText(nombres);
            etq_fecha_inicio.append(" " + cuestionario.getString("fecha_inicio"));
            etq_fecha_fin.append(" " + cuestionario.getString("fecha_fin"));
            etq_preguntas.append(" " + cuestionario.getString("cant_preguntas"));
            etq_correctas.append(" " + cuestionario.getString("cant_ok"));
            etq_incorrectas.append(" " + cuestionario.getString("cant_error"));

            id_cuestionario = cuestionario.getString("id");
            apiObtenerRespuestas(id_cuestionario);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public void apiObtenerRespuestas(String id_cuestionario) {
        System.out.println("Iniciando consumo");
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        String url = dataConfig.getEndPoint("/getRespuestas.php");

        StringRequest solicitud =  new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    System.out.println("El servidor POST responde OK");
                    JSONObject datos = new JSONObject(response);
                    System.out.println(response);

                    cargarRespuestas(datos.getJSONArray("respuestas"));
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("El servidor responde con un error:");
                System.out.println(error.getMessage());
            }
        }){
            protected Map<String, String> getParams(){
                Map<String, String> params = new HashMap<String, String>();
                params.put("id_cuestionario", id_cuestionario);

                return params;
            }
        };

        queue.add(solicitud);
    }

    public void cargarRespuestas(JSONArray respuestas) {
        try {
            for (int i = 0; i < respuestas.length(); i++) {

                JSONObject respuesta =  respuestas.getJSONObject(i);

                TextView etq_num_pregunta = new TextView(getApplicationContext());
                etq_num_pregunta.setTextSize(20);
                etq_num_pregunta.setTextColor(Color.BLACK);
                etq_num_pregunta.setPadding(0, 40, 0, 0);
                etq_num_pregunta.setText("Pregunta " + (i+1));

                TextView etq_pregunta = new TextView(getApplicationContext());
                etq_pregunta.setText(respuesta.getJSONObject("pregunta").getString("descripcion"));
                etq_pregunta.setTextColor(Color.BLACK);
                etq_pregunta.setTextSize(16);

                layoutDetalles.addView(etq_num_pregunta);
                layoutDetalles.addView(etq_pregunta);

                JSONArray opciones = respuesta.getJSONArray("opciones");
                for (int j = 0; j < opciones.length(); j++) {
                    JSONObject opcion = opciones.getJSONObject(j);

                    TextView etq_opcion = new TextView(getApplicationContext());
                    etq_opcion.setText("   - " + opcion.getString("descripcion"));
                    etq_opcion.setTextSize(14);

                    if (respuesta.getJSONObject("pregunta").getString("respuesta").equals(opcion.getString("id"))) {
                        etq_opcion.setTextColor( (respuesta.getJSONObject("pregunta").getString("estado").equals("OK"))? getResources().getColor(R.color.green) : getResources().getColor(R.color.red) );
                    } else {
                        etq_opcion.setTextColor(Color.BLACK);
                    }
                    layoutDetalles.addView(etq_opcion);
                }

            }
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }
}