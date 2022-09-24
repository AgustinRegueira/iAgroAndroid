package com.utec.iagro.models;

import java.io.Serializable;

public class Usuario implements Serializable {
    private String idUsuario;
    private String nombre;
    private String apellido;
    private String nombreUsuario;
    private String contrasena;
    private String mail;
    private String estatus;
    private String tipoUsuario;
    private String documento;
    private String domicilio;
    private String telefono;
    private String ciudad;
    private String ocupacion;

    public Usuario() {
        super();
    }

    public Usuario(String idUsuario, String nombre, String apellido, String nombreUsuario, String contrasena, String mail, String estatus, String tipoUsuario, String documento, String domicilio, String telefono, String ciudad, String ocupacion) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        this.mail = mail;
        this.estatus = estatus;
        this.tipoUsuario = tipoUsuario;
        this.documento = documento;
        this.domicilio = domicilio;
        this.telefono = telefono;
        this.ciudad = ciudad;
        this.ocupacion = ocupacion;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }
}
