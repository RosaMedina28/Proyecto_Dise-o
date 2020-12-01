package com.example.proyector;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    final private int request_code = 2000;
    private RecyclerView rvpermisos; //declaromos una varibale de tipo RecyclerView
    Button btn_registro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        rvpermisos = findViewById(R.id.RVpermisos);//buscamos el RecyclerView en el xml
        rvpermisos.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL)); //añadimos un diseño al RecyclerView(linea separadora)
        //RECLYLCERVIEW
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this); //RecyclerView de forma linearlayout
        rvpermisos.setLayoutManager(linearLayoutManager); //se lo asignamos
        setContentView(R.layout.activity_main);

        //PERMISOS
        int permisso_loc = ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_FINE_LOCATION);
        int permiso_cont =  ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.READ_CONTACTS);

        if (permisso_loc == PackageManager.PERMISSION_DENIED || permiso_cont == PackageManager.PERMISSION_DENIED)
        {
            if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
                requestPermissions(new String[] {Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.READ_CONTACTS},
                        request_code);
            }
        }

    }
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {//Parametros(idendificacion del la ventanita, identifico que permisos estoy solicitando en la ventanita en forma de arreglo, resivo un arreglo de 0 y -1 donde 0 es que acepto el permiso y -1 es que lo denego, asi con todos las permisos que solicite)
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
    }

}