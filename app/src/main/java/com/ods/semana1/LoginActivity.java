package com.ods.semana1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.hardware.lights.LightState;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class LoginActivity extends AppCompatActivity {

    EditText usuario, clave;
    Button ingresar, registrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usuario = findViewById(R.id.txtUser);
        clave = findViewById(R.id.txtClave);
        registrar = findViewById(R.id.registroNewBtn);
        ingresar = findViewById(R.id.btnInicio);

        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegistroActivity.class);
                startActivity(intent);
            }
        });
    }

    public void login(View view){
        String usu = usuario.getText().toString().trim();
        String pass = clave.getText().toString().trim();

        if(usu.isEmpty() && pass.isEmpty()){
            usuario.setError("campo usuario vacio");
            clave.setError("campo password vacio");
            return;
        }

        List<Usuario> nameuser = Usuario.findWithQuery(Usuario.class, "Select * from Usuario where nombre = ?", usu);
        Usuario user = nameuser.get(0);
        String name = user.getNombre();
        String passw = user.getPassword();
        if(nameuser.size() < 0){
            Toast.makeText(getApplicationContext(), "El usuario no existe", Toast.LENGTH_LONG).show();
        }


        if (name.equals(usu) && passw.equals(pass)) {
            Intent i = new Intent(LoginActivity.this, Inicio.class);
            i.putExtra("usuario", usu);
            i.putExtra("clave", pass);
            startActivity(i);
            limpiar();
        } else {
            Toast.makeText(getApplicationContext(), "usuario o contraseña invalido", Toast.LENGTH_LONG).show();
        }
    }

    public void limpiar(){
        usuario.setText("");
        clave.setText("");
    }

}