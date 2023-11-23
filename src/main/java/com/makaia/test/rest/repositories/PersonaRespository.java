package com.makaia.test.rest.repositories;

import com.makaia.test.rest.exceptions.MakaiaApiException;
import com.makaia.test.rest.models.Persona;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PersonaRespository {
    List<Persona> personas; // Repository

    public PersonaRespository() {
        this.personas = new ArrayList<>();
    }

    public void crearPersona(Persona persona){
        this.personas.add(persona);
    }

    public List<Persona> listarPersonas(){
        return this.personas;
    }

    public Persona getPersonaPorId(String id){
        Optional<Persona> optPersonal = this.personas.stream().filter(p-> p.getCedula().equals(id)).findFirst();
        if(optPersonal.isEmpty()){
            throw new MakaiaApiException("Persona no existe");

        }
        return optPersonal.get();
    }
}
