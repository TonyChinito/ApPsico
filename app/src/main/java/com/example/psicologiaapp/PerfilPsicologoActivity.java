package com.example.psicologiaapp;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;

public class PerfilPsicologoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_psicologo);

        // Referencia al botón cerrar
        ImageButton btnCerrar = findViewById(R.id.btnCerrar);

        // Configuración del listener para cerrar la actividad al presionar el botón
        btnCerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Cerrar la actividad actual
                finish();
            }
        });
    }
}