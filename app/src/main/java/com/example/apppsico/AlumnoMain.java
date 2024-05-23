package com.example.apppsico;
import com.example.apppsico.R;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class AlumnoMain extends AppCompatActivity {
    private static final int MENU_PERFIL = R.id.menuperfil;
    private static final int CAMBIAR_CONTRASENIA = R.id.cambiarcontrasenia;
    private static final int CERRAR_SESION = R.id.cerrarsesion;

    private Button btnMenu;
    private Button btnCuestionario;
    private Button btnCitaPsicologo;
    private EditText txtMensaje;
    private Button btnEnviar;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alumno_main);

        // Inicializar Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        // Inicializar vistas
        btnMenu = findViewById(R.id.btnMenu);
        btnCuestionario = findViewById(R.id.btnCuestionario);
        btnCitaPsicologo = findViewById(R.id.btnCitaPsicologo);
        txtMensaje = findViewById(R.id.txtMensaje);
        btnEnviar = findViewById(R.id.btnEnviar);

        // Configurar OnClickListener para el botón de Cuestionario
        btnCuestionario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Iniciar actividad del cuestionario
                startActivity(new Intent(AlumnoMain.this, CuestionarioActivity.class));
            }
        });

        // Configurar OnClickListener para el botón de Cita Psicologo
        btnCitaPsicologo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Iniciar actividad de la cita con el psicólogo
                startActivity(new Intent(AlumnoMain.this, CitaPsicologoActivity.class));
            }
        });

        // Configurar OnClickListener para el botón de enviar mensaje
        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener el texto del mensaje
                String mensaje = txtMensaje.getText().toString();

                // Verificar si el mensaje contiene palabras relacionadas con suicidio
                if (contienePalabrasSuicidas(mensaje.toLowerCase())) {
                    // Enviar mensaje con estado de alerta
                    enviarMensaje("Mensaje con estado de alerta: " + mensaje);
                    // Mostrar mensaje de alerta al usuario
                    Toast.makeText(AlumnoMain.this, "Mensaje enviado con estado de alerta", Toast.LENGTH_SHORT).show();
                } else {
                    // Enviar mensaje normalmente
                    enviarMensaje(mensaje);
                    // Mostrar mensaje de éxito al usuario
                    Toast.makeText(AlumnoMain.this, "Mensaje enviado", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menualumno, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case MENU_PERFIL:
                abrirPerfil();
                return true;
            case CAMBIAR_CONTRASENIA:
                abrirCambiarContrasenia();
                return true;
            case CERRAR_SESION:
                cerrarSesion();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    // Método para verificar si el mensaje contiene palabras relacionadas con suicidio
    private boolean contienePalabrasSuicidas(String mensaje) {
        // Aquí implementa tu lógica para verificar palabras relacionadas con suicidio
        return false; // Cambia esto según tu implementación real
    }

    // Método para enviar mensaje al psicólogo
    private void enviarMensaje(String mensaje) {
        // Aquí implementa tu lógica para enviar el mensaje al psicólogo
    }

    private void abrirPerfil() {
        // Lógica para abrir la actividad de perfil
        Intent intent = new Intent(this, PerfilActivity.class);
        startActivity(intent);
    }

    private void abrirCambiarContrasenia() {
        // Lógica para abrir la actividad de cambiar contraseña
        Intent intent = new Intent(this, CambiarContraseniaActivity.class);
        startActivity(intent);
    }

    // Método para cerrar sesión
    private void cerrarSesion() {
        mAuth.signOut();
        Intent intent = new Intent(AlumnoMain.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
