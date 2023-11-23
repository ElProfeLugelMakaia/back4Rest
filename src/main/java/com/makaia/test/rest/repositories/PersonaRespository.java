package com.makaia.test.rest.repositories;

import com.makaia.test.rest.models.Persona;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PersonaRespository {
    List<Persona> personas; // Repository

    public PersonaRespository() {
        this.personas = new ArrayList<>();
    }

    public Persona crearPersona(Persona persona){
        this.personas.add(persona);
        return persona;
    }

    public List<Persona> listarPersonas(){
        return this.personas;
    }

    public Optional<Persona> getPersonaPorId(String id){
        return this.personas.stream().filter(p-> p.getCedula().equals(id)).findFirst();
    }
}
