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

public class registroActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
    }

    public void evento_registro(View view) {
    }

    public void evento_register(View view) {
        EditText edit_apellido = findViewById(R.id.edit_apellido);
        Toast.makeText(this, edit_apellido.getText().toString(), Toast.LENGTH_SHORT).show();
    }
}
