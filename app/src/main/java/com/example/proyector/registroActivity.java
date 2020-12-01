package com.example.proyector;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class registroActivity extends Activity {

    public void evento_registro(View view) {
    }

    public void evento_register(View view) {
        EditText campo_apellido = findViewById(R.id.apellido);
        Toast.makeText(this, campo_apellido.getText().toString(), Toast.LENGTH_SHORT).show();
    }
}
