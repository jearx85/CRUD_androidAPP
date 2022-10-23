package com.ods.semana1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Inicio extends AppCompatActivity {

    TextView usu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        usu = findViewById(R.id.txtUsuario);

        Bundle bundle = getIntent().getExtras();
        String usuario = bundle.getString("usuario");
        usu.setText(usuario);
    }
}