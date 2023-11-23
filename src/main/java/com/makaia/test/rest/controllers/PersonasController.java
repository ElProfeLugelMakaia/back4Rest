package com.makaia.test.rest.controllers;

import com.makaia.test.rest.repositories.PersonaRespository;
import com.makaia.test.rest.services.PersonasService;
import com.makaia.test.rest.models.Persona;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/v1/personas")
public class PersonasController {
    private PersonasService service;

    @Autowired
    public PersonasController(PersonasService service) {
        this.service = service;
    }

    @PostMapping()
    public Persona crearPersona(@RequestBody() Persona persona){

        Persona result = service.crearPersona(persona);
        return result;
    }

    @GetMapping()
    public List<Persona> listarPersonas(){
        List<Persona> result = service.listarPersonas();
        return result;
    }

    @GetMapping("/{id}")
    public Persona getPersonaPorId(@PathVariable("id") String id){
        //try {
            Persona result = service.getPersonaPorId(id);
            return result;
        //} catch (NoSuchElementException err) {
//            System.out.println("Error: " + err.getMessage());
//            return new Persona();
//        } catch (Exception err){
//            System.out.println("Error: Ha ocurrido un error inesperado, por favor intentelo nuevamente");
//            return null;
//        }
//        finally {
//            System.out.println("Process ended");
//        }
    }

}
