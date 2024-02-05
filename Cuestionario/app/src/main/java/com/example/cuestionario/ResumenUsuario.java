package com.example.cuestionario;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

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

public class ResumenUsuario extends AppCompatActivity {
    String id_usuario;
    String nombre_usuario;
    TextView etq_usuario;
    LinearLayout layoutCuestionario;
    Config dataConfig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumen_usuario);

        dataConfig = new Config(getApplicationContext());

        etq_usuario = findViewById(R.id.etq_usuario);
        layoutCuestionario = findViewById(R.id.layoutCuestionarios);

        SharedPreferences archivo = getSharedPreferences("app_preguntas", Context.MODE_PRIVATE);
        id_usuario = archivo.getString("id_usuario", null);
        nombre_usuario = archivo.getString("nombres", null);

        etq_usuario.setText(nombre_usuario);

        FloatingActionButton btnLogOut = findViewById(R.id.floatingActionButton2);
        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logOut();
            }
        });

        FloatingActionButton btnNew = findViewById(R.id.boton_nuevo_cuestonario);
        btnNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                apiCrearCuestionario(id_usuario);
            }
        });

        validarNuevoCuestionario();
        apiObtenerCuestionarios(id_usuario);
    }

    public void nuevoCuestionario(String id_cuestionario) {

        SharedPreferences archivo = getSharedPreferences("app_preguntas", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = archivo.edit();
        editor.putString("id_cuestionario", id_cuestionario);
        editor.apply();

        Intent intencion = new Intent(getApplicationContext(), NuevoCuestionario.class);
        startActivity(intencion);
        finish();
    }

    public void logOut() {
        SharedPreferences archivo = getSharedPreferences("app_preguntas", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = archivo.edit();
        editor.clear();
        editor.apply();

        Intent intencion = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intencion);
        finish();
    }

    public void apiObtenerCuestionarios(String id_usuario) {
        System.out.println("Iniciando consumo");
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        String url = dataConfig.getEndPoint("/getCuestionarios.php");

        StringRequest solicitud =  new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    System.out.println("El servidor POST responde OK");
                    JSONObject datos = new JSONObject(response);
                    System.out.println(response);

                    cargarResumen(datos.getJSONArray("resumen"));
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
                params.put("id_usuario", id_usuario);


                return params;
            }
        };

        queue.add(solicitud);
    }

    public void apiCrearCuestionario(String id_usuario) {
        System.out.println("Iniciando consumo");
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        String url = dataConfig.getEndPoint("/crearCuestionario.php");

        StringRequest solicitud =  new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    System.out.println("El servidor POST responde OK");
                    JSONObject datos = new JSONObject(response);
                    System.out.println(response);

                    nuevoCuestionario(datos.getString("id_cuestionario"));
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
                params.put("id_usuario", id_usuario);


                return params;
            }
        };

        queue.add(solicitud);
    }

    @SuppressLint("ResourceAsColor")
    public void cargarResumen(JSONArray datos) {
        try {
            for (int i = 0; i < datos.length(); i++) {
                JSONObject cuestionario = datos.getJSONObject(i);

                TextView etiqueta = new TextView(getApplicationContext());
                etiqueta.setText("N° " + (i+1) + "\n");
                etiqueta.append("Iniciado el: " + cuestionario.getString("fecha_inicio") + "\n");
                etiqueta.append("Finalizado el: " + cuestionario.getString("fecha_fin") + "\n");
                etiqueta.append("Preguntas: " + cuestionario.getString("cant_preguntas") + "\n");
                etiqueta.append("Correctas: " + cuestionario.getString("cant_ok") + "\n");
                etiqueta.append("Erroneas: " + cuestionario.getString("cant_error"));

                etiqueta.setId(cuestionario.getInt("id"));
                etiqueta.setTextColor(Color.BLACK);
                etiqueta.setTextSize(18);
                etiqueta.setPadding(40, 40, 40, 40);

                // Configurar el margen (ajustar según tus preferencias)
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                );
                layoutParams.setMargins(0, 0, 0, 30); // valores en píxeles

                // Aplicar los parámetros de diseño al TextView
                etiqueta.setLayoutParams(layoutParams);

                // Configurar el fondo con borde redondeado
                GradientDrawable borderDrawable = new GradientDrawable();
                borderDrawable.setShape(GradientDrawable.RECTANGLE);
                borderDrawable.setCornerRadius(20); // Ajusta según tus preferencias
                borderDrawable.setStroke(10, Color.BLUE); // Ajusta el ancho y color del borde
                borderDrawable.setColor(getResources().getColor(R.color.light_blue));

                // Aplicar el fondo personalizado al TextView
                etiqueta.setBackground(borderDrawable);

                // asignado el evento click
                etiqueta.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String cuestionarioString = cuestionario.toString();
                        verDetalles(cuestionarioString);
                    }
                });

                layoutCuestionario.addView(etiqueta);
            }
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public void verDetalles(String cuestionarioString) {
        SharedPreferences archivo = getSharedPreferences("app_preguntas", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = archivo.edit();
        editor.putString("cuestionario_string", cuestionarioString);
        editor.apply();

        Intent intencion = new Intent(getApplicationContext(), DetalleCuestionario.class);
        startActivity(intencion);
    }

    public void validarNuevoCuestionario() {
        SharedPreferences archivo = getSharedPreferences("app_preguntas", Context.MODE_PRIVATE);

        String id_cuestionario = archivo.getString("id_cuestionario", null);
        System.out.println("ID CUESTIONARIO: " + id_cuestionario);

        if (id_cuestionario != null) {
            Intent intencion = new Intent(getApplicationContext(), NuevoCuestionario.class);
            startActivity(intencion);
            finish();
        }
    }
}