package com.makaia.test.rest.services;

import com.makaia.test.rest.exceptions.MakaiaApiException;
import com.makaia.test.rest.models.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class PersonasService {

    List<Persona> personas; // Repository

    @Autowired
    public PersonasService() {
        this.personas = new ArrayList<>();
    }

    public Persona crearPersona(Persona persona){
        if(persona.getNombre() == null || persona.getNombre().equals("")){
            throw new RuntimeException("El nombre es obligatorio");
        }
        this.personas.add(persona);
        return persona;
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

