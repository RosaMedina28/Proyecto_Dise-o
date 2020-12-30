package com.example.proyector;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity{
    //final private int request_code = 2000;
    RequestQueue queue;
    Button btn_login;
    private RadioButton RB;
private boolean isActivateRB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RB=(RadioButton) findViewById(R.id.RBsesion);
        isActivateRB=RB.isChecked();
        RB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isActivateRB)
                {
                    RB.setChecked(false);
                }
                isActivateRB=RB.isChecked();
            }
        });

        btn_login = findViewById(R.id.btn_login);
        btn_login.setOnClickListener(this::evento_login);

        queue = Volley.newRequestQueue(this);
        //PERMISOS
       /* int permisso_loc = ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_FINE_LOCATION);
        int permiso_cont =  ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.READ_CONTACTS);

        if (permisso_loc == PackageManager.PERMISSION_DENIED || permiso_cont == PackageManager.PERMISSION_DENIED)
        {
            if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
                requestPermissions(new String[] {Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.READ_CONTACTS},
                        request_code);
            }
        }*/

    }



    /*public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {//Parametros(idendificacion del la ventanita, identifico que permisos estoy solicitando en la ventanita en forma de arreglo, resivo un arreglo de 0 y -1 donde 0 es que acepto el permiso y -1 es que lo denego, asi con todos las permisos que solicite)
        //saber la informacion  y valores de las variables o arreglos
        Toast.makeText(this,Arrays.deepToString(permissions), Toast.LENGTH_SHORT).show();


        if (requestCode == requestCode) { //si la ventana es igual al REQUEST_CODE_ASK_PERMISSION,
            // significa que yo lanze la ventana y no otra app

            if (permissions.length >= 1) { //si tengo una respuesta de l apeticion de permisos has esto
                int permiso = PackageManager.PERMISSION_DENIED;
                int longitud = grantResults.length;

                for(int i = 0; i < longitud; i++){
                    permiso = grantResults[i];

                    if(permiso == PackageManager.PERMISSION_DENIED){
                        break;
                    }
                }

                if(permiso == PackageManager.PERMISSION_GRANTED){

                }

            }
        }
    }*/

    public void evento_login(View view) {
        Toast.makeText(this, "Entre al evento login", Toast.LENGTH_SHORT).show();
        String urlend = "http://192.168.0.31:8000/api/loginas";
        JSONObject datos = new JSONObject();

        EditText campo_email = findViewById(R.id.edit_email_l);
        EditText campo_password = findViewById(R.id.edit_password_l);


        try {
            datos.put("email", campo_email.getText().toString());
            datos.put("password",campo_password.getText().toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Toast.makeText(this, campo_email.getText().toString(), Toast.LENGTH_SHORT).show();
        JsonObjectRequest postrequest = new JsonObjectRequest(Request.Method.POST, urlend, datos, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    Toast.makeText(MainActivity.this, (CharSequence) datos, Toast.LENGTH_SHORT).show();
                    String token = response.getString("token");
                    Toast.makeText(MainActivity.this, response.toString(), Toast.LENGTH_SHORT).show();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "No se hizo peticion ", Toast.LENGTH_SHORT).show();
            }  {}
        });
        queue.add(postrequest);

        //Intent intent = new Intent (MainActivity.this, registroActivity.class);
        //startActivityForResult(intent, 0);
    }

    public void evento_registro_cambio(View view) {
        Intent intent = new Intent (MainActivity.this, registroActivity.class);
        startActivity(intent);
    }
}