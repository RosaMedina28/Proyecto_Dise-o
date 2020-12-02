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
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class ReclyclerActivity extends AppCompatActivity {
    private RecyclerView rv_permisos;
    Switch s1,s2;
    final private int request_code1 =191700;
    final private int request_code2 =191702;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_permisos);

        //rv_permisos = findViewById(R.id.rv_permisos);
        //rv_permisos.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL)); //linea de separacion

        //LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        //rv_permisos.setLayoutManager(linearLayoutManager);

        ArrayList<Permiso> lista = new ArrayList<>();
        lista.add(new Permiso("Camara")); //aqui tengo mis dudas
        lista.add(new Permiso("Contactos"));

        //PermisoAdapter Adapter = new PermisoAdapter(lista);
        //rv_permisos.setAdapter(Adapter);

    }
    public void evento_switch(View view) {

        s1 = findViewById(R.id.switch_permiso1);
        s2 = findViewById(R.id.switch_permiso2);

        switch (view.getId()) {
            case R.id.switch_permiso1:
                    if(s1.isChecked()){
                        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){ //Build.VERSION.SDK_INT obtiene mi version de android y comprueva que sea mayor a la version 6.0  // Build.VERSION_CODES.M esto se puede reemplazar con un 23 que e su identificador
                            requestPermissions(new String[]{Manifest.permission.CAMERA}, request_code1); //lanzo la ventanita o alerta y le asignamos un identificador //con esto posteriormente podemos saber si acepto y denego la ventana con el id=1917
                        }
                    }else{

                    }
                break;
            case R.id.switch_permiso2:
                if(s2.isChecked()){
                    if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){ //Build.VERSION.SDK_INT obtiene mi version de android y comprueva que sea mayor a la version 6.0  // Build.VERSION_CODES.M esto se puede reemplazar con un 23 que e su identificador
                        requestPermissions(new String[]{Manifest.permission.READ_CONTACTS}, request_code2); //lanzo la ventanita o alerta y le asignamos un identificador //con esto posteriormente podemos saber si acepto y denego la ventana con el id=1917
                    }
                }else{

                }
                break;

        }
    }
     public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {//Parametros(idendificacion del la ventanita, identifico que permisos estoy solicitando en la ventanita en forma de arreglo, resivo un arreglo de 0 y -1 donde 0 es que acepto el permiso y -1 es que lo denego, asi con todos las permisos que solicite)
        //saber la informacion  y valores de las variables o arreglos
         int camara = ActivityCompat.checkSelfPermission(ReclyclerActivity.this, Manifest.permission.CAMERA);
         int contactos = ActivityCompat.checkSelfPermission(ReclyclerActivity.this, Manifest.permission.READ_CONTACTS);
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

                if(camara == PackageManager.PERMISSION_GRANTED && contactos == PackageManager.PERMISSION_GRANTED){
                    Intent intent = new Intent (ReclyclerActivity.this, MainActivity.class);
                    startActivity(intent);
                }
                Toast.makeText(this, "No se an consedido todos los permisos", Toast.LENGTH_SHORT).show();

            }
        }
    }





}