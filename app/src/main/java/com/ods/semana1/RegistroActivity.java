package com.ods.semana1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;


public class RegistroActivity extends AppCompatActivity {

    EditText nombre, documento, clave, confirmar;
    Button guardar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        nombre = findViewById(R.id.nameTxt);
        documento = findViewById(R.id.docTxt);
        clave = findViewById(R.id.contrasenaTxt);
        confirmar = findViewById(R.id.confirmTxt);

        guardar = findViewById(R.id.regBtn);

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nom = nombre.getText().toString();
                String doc = documento.getText().toString();
                String pas = clave.getText().toString();
                String conf = confirmar.getText().toString();

                if(nom.isEmpty() && doc.isEmpty() && pas.isEmpty() && conf.isEmpty()) {
                    nombre.setError("Nombre vacio");
                    documento.setError("Documento vacio");
                    clave.setError("Password vacio");
                    confirmar.setError("Password vacio");
                } else if(nom.isEmpty()) {
                    nombre.setError("Nombre vacio");
                } else if(doc.isEmpty()) {
                    documento.setError("Documento vacio");
                } else if(pas.isEmpty()) {
                    clave.setError("Password vacio");
                } else if(conf.isEmpty()) {
                    confirmar.setError("Password vacio");
                }else if(!pas.equals(conf)){
                    Toast.makeText(getApplicationContext(), "La contraseña no coincide", Toast.LENGTH_LONG).show();
                }else if(doc.length() <= 5){
                    documento.setError("Documento muy corto");
                }else if(nom.length() <= 4){
                    nombre.setError("nombre muy corto");
                }else if(pas.length() <= 4){
                    clave.setError("contraseña muy corta");
                }else if (!nom.isEmpty() && !doc.isEmpty() && !pas.isEmpty() && !conf.isEmpty() && pas.equals(conf) && conf.equals(pas)) {
                    Usuario user = new Usuario(nom, doc, pas, conf);
                    user.save();
                    limpiar();
                    Toast.makeText(getApplicationContext(), "Usuario guardado con exito", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void limpiar(){
        nombre.setText("");
        documento.setText("");
        clave.setText("");
        confirmar.setText("");
    }
}