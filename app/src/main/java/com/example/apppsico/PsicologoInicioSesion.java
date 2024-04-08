package com.example.apppsico;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PsicologoInicioSesion extends AppCompatActivity {

    private EditText editTextEmail;
    private EditText editTextPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_psicologo_inicio_sesion);

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
                    // Aquí puedes agregar tu lógica para iniciar sesión como psicólogo
                    // Por ejemplo, puedes llamar a un método para realizar la autenticación
                    // authenticatePsicologo(email, password);
                }
            }
        });
    }
}