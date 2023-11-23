package com.makaia.test.rest.services;

import com.makaia.test.rest.exceptions.MakaiaApiException;
import com.makaia.test.rest.models.Persona;
import com.makaia.test.rest.repositories.PersonaRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class PersonasService {

    PersonaRespository repository;

    @Autowired
    public PersonasService(PersonaRespository repository) {
        this.repository = repository;
    }

    public Persona crearPersona(Persona persona){
        if(persona.getNombre() == null || persona.getNombre().equals("")){
            throw new RuntimeException("El nombre es obligatorio");
        }
        this.repository.crearPersona(persona);
        return persona;
    }


    public List<Persona> listarPersonas(){
        return this.repository.listarPersonas();
    }

    public Persona getPersonaPorId(String id){
        return this.repository.getPersonaPorId(id);
    }

}

