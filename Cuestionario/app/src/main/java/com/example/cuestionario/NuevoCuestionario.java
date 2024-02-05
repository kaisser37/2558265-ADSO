package com.example.cuestionario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.cuestionario.utils.Config;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class NuevoCuestionario extends AppCompatActivity {

    TextView etq_nombre_usuario;
    TextView etq_fecha_inicio;

    Config dataConfig;
    String id_cuestionario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_cuestionario);

        dataConfig = new Config(getApplicationContext());

        SharedPreferences archivo = getSharedPreferences("app_preguntas", Context.MODE_PRIVATE);
        String nombre_usuario = archivo.getString("nombres", null);
        id_cuestionario = archivo.getString("id_cuestionario", null);

        etq_nombre_usuario = findViewById(R.id.etq_nombre_usuario);
        etq_nombre_usuario.setText(nombre_usuario);

        etq_fecha_inicio = findViewById(R.id.etq_fecha_inicio);

        apiFechaInicio(id_cuestionario);

    }

    public void apiFechaInicio(String id_cuestionario) {
        System.out.println("Iniciando consumo");
        System.out.println("id cuestionario en api: " + id_cuestionario);
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        String url = dataConfig.getEndPoint("/getFechaInicio.php");

        StringRequest solicitud =  new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    System.out.println("El servidor POST responde OK");
                    JSONObject datos = new JSONObject(response);
                    System.out.println(response);

                    String fecha = datos.getJSONArray("cuestionario").getJSONObject(0).getString("fecha_inicio");
                    etq_fecha_inicio.setText(fecha);
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

    public void iniciarCuestionario(View vista) {
        Intent intencion = new Intent(getApplicationContext(), Cuestionario.class);
        startActivity(intencion);
        finish();
    }

}