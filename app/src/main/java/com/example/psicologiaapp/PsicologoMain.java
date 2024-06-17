package com.example.psicologiaapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.auth.FirebaseAuth;

public class PsicologoMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_psicologo_main);

        // Configurar listener para el botón "Programar Prueba"
        findViewById(R.id.btnProgramarPrueba).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openProgramarPrueba();
            }
        });

        // Configurar listener para el botón "Agenda"
        findViewById(R.id.btnAgenda).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAgenda();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_alumno_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.menu_change_password) {
            openChangePassword();
            return true;
        } else if (id == R.id.menu_profile) {
            openProfile();
            return true;
        } else if (id == R.id.menu_logout) {
            logout();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void logout() {
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(PsicologoMain.this, MainActivity.class);
        startActivity(intent);
        finish(); // Cerrar la actividad actual
    }

    private void openProfile() {
        Intent intent = new Intent(PsicologoMain.this, PerfilPsicologoActivity.class);
        startActivity(intent);
    }

    private void openChangePassword() {
        Intent intent = new Intent(PsicologoMain.this, CambiarContraseniaActivity.class);
        startActivity(intent);
    }

    private void openProgramarPrueba() {
        Intent intent = new Intent(PsicologoMain.this, ProgramarPruebaActivity.class); // Reemplaza con la actividad correspondiente
        startActivity(intent);
    }

    private void openAgenda() {
        Intent intent = new Intent(PsicologoMain.this, AgendaActivity.class); // Reemplaza con la actividad correspondiente
        startActivity(intent);
    }
}