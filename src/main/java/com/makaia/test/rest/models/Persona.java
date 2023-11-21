package com.makaia.test.rest.models;

public class Persona {
    private String nombre;
    private String apellido;
    private String cedula;
    private String ciudad;

    public Persona() {
    }

    public Persona(String nombre, String apellido, String cedula, String ciudad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.ciudad = ciudad;
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

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }


    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", cedula='" + cedula + '\'' +
                ", ciudad='" + ciudad + '\'' +
                '}';
    }
}
