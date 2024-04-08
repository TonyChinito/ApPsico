package com.example.apppsico;

import android.os.Bundle;
import android.content.Intent;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button btnAlumno, btnPsicologo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Obtener referencias a los botones
        btnAlumno = findViewById(R.id.btnAlumno);
        btnPsicologo = findViewById(R.id.btnPsicologo);

        // Configurar el OnClickListener para el botón Alumno
        btnAlumno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Crear un Intent para abrir la actividad correspondiente (reemplaza LoginActivity.class con la actividad que deseas abrir)
                Intent intent = new Intent(MainActivity.this, AlumnoInicioSesion.class);
                // Agregar cualquier dato extra al Intent si es necesario
                intent.putExtra("tipoUsuario", "Alumno");
                // Iniciar la actividad
                startActivity(intent);
            }
        });

        // Configurar el OnClickListener para el botón Psicologo
        btnPsicologo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Crear un Intent para abrir la actividad correspondiente (reemplaza LoginActivity.class con la actividad que deseas abrir)
                Intent intent = new Intent(MainActivity.this, PsicologoInicioSesion.class);
                // Agregar cualquier dato extra al Intent si es necesario
                intent.putExtra("tipoUsuario", "Psicologo");
                // Iniciar la actividad
                startActivity(intent);
            }
        });
    }
}