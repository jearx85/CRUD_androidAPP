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
    Button guardar, consultar, eliminar, actualizar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        nombre = findViewById(R.id.nameTxt);
        documento = findViewById(R.id.docTxt);
        clave = findViewById(R.id.contrasenaTxt);
        confirmar = findViewById(R.id.confirmTxt);

        consultar = findViewById(R.id.consultarbutton);
        guardar = findViewById(R.id.regBtn);
        eliminar = findViewById(R.id.eliminarbutton);
        actualizar = findViewById(R.id.updatebutton);

        actualizar.setVisibility(View.INVISIBLE);


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
                }else if (!nom.isEmpty() && !doc.isEmpty() && !pas.isEmpty() && !conf.isEmpty() && pas.equals(conf) && conf.equals(pas)) {
                    Usuario user = new Usuario(nom, doc, pas, conf);
                    user.save();
                    limpiar();
                    Toast.makeText(getApplicationContext(), "Usuario guardado con exito", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void Consultar(View view){
        String doc = documento.getText().toString();
        if(doc.isEmpty()) {
            documento.setError("Digite el documento");
        }else {
            List<Usuario> lista = Usuario.find(Usuario.class, "documento=" + doc, null);
            if (lista.size() <= 0) {
                Toast.makeText(getApplicationContext(), "usuario no existe", Toast.LENGTH_LONG).show();
                limpiar();
            } else {
                Usuario user = lista.get(0);
                nombre.setText(user.getNombre());
                clave.setText(user.getPassword());
                confirmar.setText(user.getConfPass());
                actualizar.setVisibility(View.VISIBLE);
                guardar.setVisibility(View.INVISIBLE);

            }
        }
    }

    public void Eliminar(View view) {
        String doc = documento.getText().toString();
        if(doc.isEmpty()) {
            documento.setError("Digite el documento");
        }else {
            List<Usuario> lista = Usuario.find(Usuario.class, "documento=" + doc, null);
            if (lista.size() <= 0) {
                Toast.makeText(getApplicationContext(), "usuario no existe", Toast.LENGTH_LONG).show();
                limpiar();
            } else {
                Usuario user = lista.get(0);
                user.delete();
                Toast.makeText(getApplicationContext(), "usuario eliminado", Toast.LENGTH_LONG).show();
                limpiar();
            }
        }
    }

    public void Actualizar(View view) {
        String doc = documento.getText().toString();
        String nom = nombre.getText().toString();
        String pas = clave.getText().toString();
        String conf = confirmar.getText().toString();
        if(doc.isEmpty()) {
            documento.setError("Digite el documento");
        }else {
            List<Usuario> lista = Usuario.find(Usuario.class, "documento=" + doc, null);
            if (lista.size() <= 0) {
                Toast.makeText(getApplicationContext(), "usuario no existe", Toast.LENGTH_LONG).show();

            } else {
                Usuario user = lista.get(0);
                user.setNombre(nombre.getText().toString());
                user.setPassword(clave.getText().toString());
                user.setConfPass(confirmar.getText().toString());


                if (nom.isEmpty() && doc.isEmpty() && pas.isEmpty() && conf.isEmpty()) {
                    nombre.setError("Nombre vacio");
                    documento.setError("Documento vacio");
                    clave.setError("Password vacio");
                    confirmar.setError("Password vacio");
                } else if (nom.isEmpty()) {
                    nombre.setError("Nombre vacio");
                } else if (doc.isEmpty()) {
                    documento.setError("Documento vacio");
                } else if (pas.isEmpty()) {
                    clave.setError("Password vacio");
                } else if (conf.isEmpty()) {
                    confirmar.setError("Password vacio");
                } else if (!pas.equals(conf)) {
                    Toast.makeText(getApplicationContext(), "La contraseña no coincide", Toast.LENGTH_LONG).show();
                } else if (doc.length() <= 5) {
                    documento.setError("Documento muy corto");
                } else if (!nom.isEmpty() && !doc.isEmpty() && !pas.isEmpty() && !conf.isEmpty() && pas.equals(conf) && conf.equals(pas)) {
                    user.save();
                    Toast.makeText(getApplicationContext(), "usuario actualizado", Toast.LENGTH_LONG).show();
                    limpiar();
                    guardar.setVisibility(View.VISIBLE);
                }
            }
        }
    }

    public void limpiar(){
        nombre.setText("");
        documento.setText("");
        clave.setText("");
        confirmar.setText("");
    }
}