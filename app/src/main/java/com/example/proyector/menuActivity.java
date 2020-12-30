package com.example.proyector;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

public class menuActivity extends AppCompatActivity {
    private final int DURACION_SPLASH=3000;
    private final int request_code = 1917;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_menu);

        new Handler().postDelayed(new Runnable() {
            public void run() {
                //PERMISOS
                int camara = ActivityCompat.checkSelfPermission(menuActivity.this, Manifest.permission.CAMERA);
                int contactos =  ActivityCompat.checkSelfPermission(menuActivity.this, Manifest.permission.READ_CONTACTS);

                if (camara == PackageManager.PERMISSION_DENIED || contactos == PackageManager.PERMISSION_DENIED){
                    Intent intent= new Intent(menuActivity.this, ReclyclerActivity.class);
                    startActivity(intent);
                    finish();
                }else{
                    Intent intent= new Intent(menuActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }

            }
        }, DURACION_SPLASH);
    }
}