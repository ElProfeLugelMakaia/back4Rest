package com.makaia.test.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

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
