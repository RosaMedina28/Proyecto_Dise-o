package com.example.proyector;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.os.Bundle;

import java.util.ArrayList;

public class ReclyclerActivity extends AppCompatActivity {
    private RecyclerView rv_permisos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reclycler);

        rv_permisos = findViewById(R.id.rv_permisos);
        rv_permisos.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL)); //linea de separacion

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rv_permisos.setLayoutManager(linearLayoutManager);

        int Camara = ActivityCompat.checkSelfPermission(ReclyclerActivity.this, Manifest.permission.CAMERA);
        int Contactos =  ActivityCompat.checkSelfPermission(ReclyclerActivity.this, Manifest.permission.READ_CONTACTS);
        ArrayList<Permiso> lista = new ArrayList<>();
        lista.add(new Permiso("Camara")); //aqui tengo mis dudas
        lista.add(new Permiso("Contactos"));

        PermisoAdapter Adapter = new PermisoAdapter(lista);
        rv_permisos.setAdapter(Adapter);
    }

}