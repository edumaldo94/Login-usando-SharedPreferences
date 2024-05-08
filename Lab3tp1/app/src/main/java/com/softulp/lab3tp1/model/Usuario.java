package com.softulp.lab3tp1.model;

import java.io.Serializable;
import java.util.Objects;

public class Usuario implements Serializable {
    private long dni;
    private String apellido, nombre, mail, password;

    public Usuario(long dni, String apellido, String nombre, String mail, String password) {
        this.dni = dni;
        this.apellido = apellido;
        this.nombre = nombre;
        this.mail = mail;
        this.password = password;
    }

    public long getDni() {
        return dni;
    }

    public void setDni(long dni) {
        this.dni = dni;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String toString(){
        return "Usuario{"+"dni= "+dni+" apellido= "+apellido+" nombre= "+nombre+" mail= "+mail+" password= "+password+'}';
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Usuario usuario = (Usuario) obj;
        return dni == usuario.dni &&
                Objects.equals(apellido, usuario.apellido) &&
                Objects.equals(nombre, usuario.nombre) &&
                Objects.equals(mail, usuario.mail) &&
                Objects.equals(password, usuario.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dni, apellido, nombre, mail, password);
    }
}
