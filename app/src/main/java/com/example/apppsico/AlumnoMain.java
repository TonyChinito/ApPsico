package com.example.apppsico;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class AlumnoMain extends AppCompatActivity {

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

        // Configurar OnClickListener para el botón de Menú
        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupMenu();
            }
        });

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

    // Método para mostrar el menú desplegable
    private void showPopupMenu() {
        PopupMenu popupMenu = new PopupMenu(this, btnMenu);
        popupMenu.getMenuInflater().inflate(R.menu.menu_alumno_main, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {

            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_perfil:
                        // Acción para la opción "Perfil"
                        startActivity(new Intent(AlumnoMain.this, PerfilActivity.class));
                        return true;
                    case R.id.menu_cambiar_contrasenia:
                        // Acción para la opción "Cambiar Contraseña"
                        startActivity(new Intent(AlumnoMain.this, CambiarContraseniaActivity.class));
                        return true;
                    case R.id.menu_cerrar_sesion:
                        // Acción para la opción "Cerrar Sesión"
                        cerrarSesion();
                        return true;
                    default:
                        return false;
                }
            }
        });
        popupMenu.show();
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

    // Método para cerrar sesión
    private void cerrarSesion() {
        mAuth.signOut();
        Intent intent = new Intent(AlumnoMain.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
