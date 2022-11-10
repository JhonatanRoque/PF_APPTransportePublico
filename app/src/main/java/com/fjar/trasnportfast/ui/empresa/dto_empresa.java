package com.fjar.trasnportfast.ui.empresa;

public class dto_empresa {
    int id_empresa;
    String nombre;
    String Telefono;
    String correo;
    String direccion;
    int codigo_postal;
    String clave;

    public dto_empresa() {
    }

    public dto_empresa(int id_empresa, String nombre, String telefono, String correo, String direccion, int codigo_postal, String clave) {
        this.id_empresa = id_empresa;
        this.nombre = nombre;
        Telefono = telefono;
        this.correo = correo;
        this.direccion = direccion;
        this.codigo_postal = codigo_postal;
        this.clave = clave;
    }

    public int getId_empresa() {
        return id_empresa;
    }

    public void setId_empresa(int id_empresa) {
        this.id_empresa = id_empresa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getCodigo_postal() {
        return codigo_postal;
    }

    public void setCodigo_postal(int codigo_postal) {
        this.codigo_postal = codigo_postal;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
}
