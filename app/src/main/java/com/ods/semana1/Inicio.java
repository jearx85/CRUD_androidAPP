package com.ods.semana1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class Inicio extends AppCompatActivity {

    TextView usu;
    Button registrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        registrar = findViewById(R.id.buttonConsul);
        usu = findViewById(R.id.txtUsuario);

        Bundle bundle = getIntent().getExtras();
        String usuario = bundle.getString("usuario");
        usu.setText(usuario);

        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Inicio.this, GestionDatos.class);
                startActivity(intent);
            }
        });

    }
}