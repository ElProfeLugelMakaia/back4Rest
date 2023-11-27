package com.makaia.test.rest.builders;

import com.makaia.test.rest.models.Persona;

public class PersonaBuilder {
    private String nombre;
    private String apellido;
    private String cedula;
    private String ciudad;

    public PersonaBuilder() {    }

    public PersonaBuilder carlos() {
        this.nombre  = "Carlos";
        this.apellido = "giraldo";
        this.cedula = "123455";
        this.ciudad = "Medellín";
        return this;

    }
    public PersonaBuilder withNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public PersonaBuilder withApellido(String apellido) {
        this.apellido = apellido;
        return this;
    }


    public PersonaBuilder withCedula(String cedula) {
        this.cedula = cedula;
        return this;
    }


    public PersonaBuilder withCiudad(String ciudad) {
        this.ciudad = ciudad;
        return this;
    }

    public Persona build() {
        return new Persona(0, this.nombre, this.apellido, this.cedula, this.ciudad);
    }
}
