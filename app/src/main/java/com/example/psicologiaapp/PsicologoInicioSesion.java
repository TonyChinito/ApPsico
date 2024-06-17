package com.example.psicologiaapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class PsicologoInicioSesion extends AppCompatActivity {

    private EditText editTextEmail;
    private EditText editTextPassword;
    private Button btnLogin;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_psicologo_inicio_sesion);

        // Inicializar Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        // Inicializar vistas
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        btnLogin = findViewById(R.id.btnLogin);

        // Configurar OnClickListener para el botón de inicio de sesión
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener texto de los campos de email y contraseña
                String email = editTextEmail.getText().toString();
                String password = editTextPassword.getText().toString();

                // Verificar si los campos están vacíos
                if (email.isEmpty() || password.isEmpty()) {
                    // Mostrar mensaje de error
                    Toast.makeText(PsicologoInicioSesion.this, "Email y contraseña son obligatorios", Toast.LENGTH_SHORT).show();
                } else {
                    // Iniciar sesión con Firebase
                    mAuth.signInWithEmailAndPassword(email, password)
                            .addOnCompleteListener(PsicologoInicioSesion.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        // Inicio de sesión exitoso, redirigir a la actividad principal del psicólogo
                                        Intent intent = new Intent(PsicologoInicioSesion.this, PsicologoMainActivity.class);
                                        startActivity(intent);
                                        finish(); // Cerrar la actividad actual
                                    } else {
                                        // El inicio de sesión falló, mostrar un mensaje de error
                                        Toast.makeText(PsicologoInicioSesion.this, "Credenciales incorrectas", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                }
            }
        });
    }
}
