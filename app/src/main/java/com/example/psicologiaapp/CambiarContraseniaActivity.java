package com.example.psicologiaapp;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class CambiarContraseniaActivity extends AppCompatActivity {

    private EditText editTextNuevaPassword;
    private EditText editTextConfirmarPassword;
    private Button btnCambiarContrasenia;
    private Button btnCerrar;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cambiar_contrasenia);

        mAuth = FirebaseAuth.getInstance();

        editTextNuevaPassword = findViewById(R.id.editTextNuevaPassword);
        editTextConfirmarPassword = findViewById(R.id.editTextConfirmarPassword);
        btnCambiarContrasenia = findViewById(R.id.btnCambiarContrasenia);
        btnCerrar = findViewById(R.id.btnCerrar);

        btnCambiarContrasenia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cambiarContrasenia();
            }
        });

        btnCerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void cambiarContrasenia() {
        String nuevaPassword = editTextNuevaPassword.getText().toString().trim();
        String confirmarPassword = editTextConfirmarPassword.getText().toString().trim();

        if (TextUtils.isEmpty(nuevaPassword) || TextUtils.isEmpty(confirmarPassword)) {
            Toast.makeText(this, "Por favor, ingresa la nueva contraseña y confírmala.", Toast.LENGTH_SHORT).show();
        } else if (!nuevaPassword.equals(confirmarPassword)) {
            Toast.makeText(this, "Las contraseñas no coinciden. Por favor, inténtalo de nuevo.", Toast.LENGTH_SHORT).show();
        } else {
            FirebaseUser user = mAuth.getCurrentUser();
            if (user != null) {
                user.updatePassword(nuevaPassword).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(CambiarContraseniaActivity.this, "Contraseña cambiada exitosamente", Toast.LENGTH_SHORT).show();
                            finish();
                        } else {
                            Toast.makeText(CambiarContraseniaActivity.this, "Error al cambiar la contraseña", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            } else {
                Toast.makeText(this, "Usuario no encontrado", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
