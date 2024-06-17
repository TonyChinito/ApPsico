package com.example.psicologiaapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.auth.FirebaseAuth;

public class AlumnoMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alumno_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_alumno_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.menu_logout) {
            logout();
            return true;
        } else if (id == R.id.menu_profile) {
            openProfile();
            return true;
        } else if (id == R.id.menu_change_password) {
            openChangePassword();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void logout() {
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(AlumnoMain.this, MainActivity.class);
        startActivity(intent);
        finish(); // Cerrar la actividad actual
    }

    private void openProfile() {
        Intent intent = new Intent(AlumnoMain.this, PerfilActivity.class);
        startActivity(intent);
    }

    private void openChangePassword() {
        Intent intent = new Intent(AlumnoMain.this, CambiarContraseniaActivity.class);
        startActivity(intent);
    }
    private void openCuestionario() {
        Intent intent = new Intent(AlumnoMain.this, CuestionarioActivity.class);
        startActivity(intent);
    }

    private void openCitaPsicologo() {
        Intent intent = new Intent(AlumnoMain.this, CitaPsicologoActivity.class);
        startActivity(intent);
    }
}
