package com.ods.semana1;

import com.orm.SugarRecord;

public class Usuario extends SugarRecord<Usuario> {

    private String nombre;
    private String documento;
    private String password;
    private String confPass;

    public Usuario(){

    }

    public Usuario(String nombre, String documento, String password, String confPass) {
        this.nombre = nombre;
        this.documento = documento;
        this.password = password;
        this.confPass = confPass;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfPass() {
        return confPass;
    }

    public void setConfPass(String confPass) {
        this.confPass = confPass;
    }
}
