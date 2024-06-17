package com.example.psicologiaapp;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;

public class PerfilActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_alumno_activityi);

        // Obtener la referencia del botón de cierre
        ImageButton btnCerrar = findViewById(R.id.btnCerrar);

        // Establecer el OnClickListener para el botón de cierre
        btnCerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Finalizar la actividad actual y regresar a la anterior
                finish();
            }
        });
    }
}
