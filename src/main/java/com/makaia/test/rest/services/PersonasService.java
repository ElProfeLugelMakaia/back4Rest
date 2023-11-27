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

    public Persona crearPersona(Persona persona) {
        Optional<Persona> exists = this.repository.findById(persona.getId());

        if(exists.isPresent()){
            throw new MakaiaApiException("La Persona ya existe");
        }
        if(persona.getNombre() == null || persona.getNombre().equals("")){
            throw new MakaiaApiException("El nombre es obligatorio");
        }
        return this.repository.save(persona);
    }

    public List<Persona> listarPersonas(){
        return this.repository.findAll();
    }

    public Persona getPersonaPorId(Long id){
        Optional<Persona> optPersonal = this.repository.findById(id);
        if(optPersonal.isEmpty()){
            throw new MakaiaApiException("Persona no existe");
        }
        return optPersonal.get();
    }
}

