package com.example.cuestionario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.cuestionario.utils.Config;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Cuestionario extends AppCompatActivity {

    Config dataConfig;
    String id_cuestionario;
    String nombre_usuario;
    LinearLayout layoutCuestionario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuestionario);
        dataConfig = new Config(getApplicationContext());

        layoutCuestionario = findViewById(R.id.layoutCuestionario);

        SharedPreferences archivo = getSharedPreferences("app_preguntas", Context.MODE_PRIVATE);
        id_cuestionario = archivo.getString("id_cuestionario", null);
        nombre_usuario = archivo.getString("nombres", null);


        apiObtenerOtraPregunta(id_cuestionario);
    }

    public void apiObtenerOtraPregunta(String id_cuestionario) {
        System.out.println("Iniciando consumo");
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        String url = dataConfig.getEndPoint("/getOtherPregunta.php");

        StringRequest solicitud =  new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    System.out.println("El servidor POST responde OK");
                    JSONObject datos = new JSONObject(response);
                    System.out.println(response);

                    cargarContenido(datos);
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

    public void cargarContenido(JSONObject datos) {
        try {
            JSONObject pregunta = datos.getJSONObject("pregunta");
            TextView etq_nombres = new TextView(getApplicationContext());
            etq_nombres.setText(nombre_usuario);

            TextView etq_preg_actual = new TextView(getApplicationContext());
            etq_preg_actual.setText("Pregunta Actual: " + pregunta.getString("id"));

            TextView etq_pregunta = new TextView(getApplicationContext());
            etq_pregunta.setText(pregunta.getString("descripcion"));

            // Crea un nuevo ImageView
            ImageView imageView = new ImageView(getApplicationContext());

            // Establece el ancho y alto del ImageView (puedes ajustarlo según tus necesidades)
            imageView.setLayoutParams(new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
            ));

            // Agrega el ImageView al diseño principal (puedes usar un LinearLayout, RelativeLayout, etc.)

            // URL de la imagen que deseas cargar
            String imageUrl = pregunta.getString("url_imagen");

            // Carga la imagen en el ImageView utilizando Picasso
            Picasso.get().load(imageUrl).into(imageView);

            layoutCuestionario.addView(etq_nombres);
            layoutCuestionario.addView(etq_preg_actual);
            layoutCuestionario.addView(imageView);


        } catch (JSONException e) {
            throw new RuntimeException(e);
        }



    }
}