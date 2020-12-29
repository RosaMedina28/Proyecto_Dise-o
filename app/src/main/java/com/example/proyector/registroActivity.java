package com.example.proyector;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class registroActivity extends AppCompatActivity {
    RequestQueue queue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        queue = Volley.newRequestQueue(this);
    }

    public void evento_registro(View view) {
    }

    public void evento_register(View view) {
        String urlend = "http://192.168.0.31:8000/api/registroas";
        JSONObject datos = new JSONObject();

        EditText edit_nombre = findViewById(R.id.edit_nombre);
        EditText edit_apellido = findViewById(R.id.edit_apellido);
        EditText edit_edad = findViewById(R.id.edit_edad);
        EditText edit_correo = findViewById(R.id.edit_correo);
        EditText edit_password = findViewById(R.id.edit_password);
        EditText edit_genero = findViewById(R.id.edit_genero);

        try {
            datos.put("nombre", edit_nombre.getText().toString());
            datos.put("apellidos",edit_apellido.getText().toString());
            datos.put("genero",edit_genero.getText().toString());
            datos.put("edad",edit_edad.getText().toString());
            datos.put("email",edit_correo.getText().toString());
            datos.put("password",edit_password.getText().toString());

        } catch (JSONException e) {
            e.printStackTrace();
        }

        JsonObjectRequest registerrequest = new JsonObjectRequest(Request.Method.POST, urlend, datos, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Toast.makeText(registroActivity.this, response.toString(), Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(registerrequest);

        Intent intent = new Intent (registroActivity.this, MainActivity.class);
        startActivityForResult(intent, 0);
    }


}
