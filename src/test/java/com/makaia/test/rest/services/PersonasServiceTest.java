package com.makaia.test.rest.services;

import com.makaia.test.rest.models.Persona;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PersonasServiceTest {

    @Test
    void crearPersonaCrearPersonaSatisfactoriamente() {
        Persona carlos = new Persona("Carlos", "giraldo", "123455", "Medellín");

        PersonasService service = new PersonasService();

        service.crearPersona(carlos);

        assertTrue(service.listarPersonas().contains(carlos));
    }

    @Test
    void crearPersonaDebeArrojarUnErrorCuandoSeCreaUnaPersonaConNombreNull() {
        Persona carlos = new Persona(null, "giraldo", "123455", "Medellín");

        PersonasService service = new PersonasService();

        try {
            service.crearPersona(carlos);
            fail();
        } catch(RuntimeException err) {
            assertTrue(err.getMessage().contains("El nombre es obligatorio"));
        }
    }

    @Test
    void crearPersonaDebeArrojarUnErrorCuandoSeCreaUnaPersonaConNombreVacio() {
        Persona carlos = new Persona("", "giraldo", "123455", "Medellín");

        PersonasService service = new PersonasService();

        assertThrows(RuntimeException.class, () -> service.crearPersona(carlos));
    }


    @Test
    void listarPersonasDebeRetornarCarlosYDavidCuandoSeAgregaronPreviamente() {
        // Arrange
        int expectedListSize = 2;
        Persona carlos = new Persona("Carlos", "giraldo", "123455", "Medellín");
        Persona david = new Persona("David", "De los Rios", "52345623", "Medellín");

        PersonasService service = new PersonasService();
        service.crearPersona(carlos);
        service.crearPersona(david);

        // Act
        List<Persona> listaPersonas = service.listarPersonas();

        // Assert
        assertTrue(listaPersonas.contains(carlos));
        assertTrue(listaPersonas.contains(david));
        assertEquals(expectedListSize, listaPersonas.size());
    }

    // Caso exitoso
    // Caso de una lista vacía
    // Caso de un id malo
}