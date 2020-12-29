package com.example.proyector;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Switchcasa extends AppCompatActivity {
    ArrayList<SwitchVo> listaswitch;
    RecyclerView recyclerswitchs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_permisos);
        listaswitch = new ArrayList<>();
        recyclerswitchs= (RecyclerView) findViewById(R.id.my_recycler_view);
        recyclerswitchs.setLayoutManager(new LinearLayoutManager(this));

        llenar_switch();
        SwitchsFocos adapter= new SwitchsFocos(listaswitch);
        recyclerswitchs.setAdapter(adapter);
    }
    private void llenar_switch() {
        listaswitch.add(new SwitchVo("Cuarto"));
        listaswitch.add(new SwitchVo("Cocina"));
        listaswitch.add(new SwitchVo("Baño"));
        listaswitch.add(new SwitchVo("Sala"));
        listaswitch.add(new SwitchVo("Oficina"));
        listaswitch.add(new SwitchVo("Cochera"));
    }
}
