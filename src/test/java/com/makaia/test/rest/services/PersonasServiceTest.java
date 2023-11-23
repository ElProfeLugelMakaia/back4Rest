package com.makaia.test.rest.services;

import com.makaia.test.rest.builders.PersonaBuilder;
import com.makaia.test.rest.exceptions.MakaiaApiException;
import com.makaia.test.rest.models.Persona;
import com.makaia.test.rest.repositories.PersonaRespository;
import org.junit.jupiter.api.*;
import org.mockito.Mock;
import org.mockito.Mockito;

import org.mockito.mock.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class PersonasServiceTest {

    PersonasService service;
    static PersonaBuilder builder;
    PersonaRespository respository;

    @BeforeAll
    static void beforeAll(){
        System.out.println("Se ejecuta antes de TODAS las pruebas");
        builder = new PersonaBuilder();
    }

    @AfterAll
    static void afterAll(){
        System.out.println("Se ejecuta después de TODAS las pruebas");
    }

    @BeforeEach
    void beforeEach() {


        respository = Mockito.mock(PersonaRespository.class);
        this.service = new PersonasService(respository);
        System.out.println("Se ejecuta antes de cada prueba");
    }

    @AfterEach
    void afterEach() {
        System.out.println("Se ejecuta despues de cada prueba");
    }

    @Test
    void crearPersonaCrearPersonaSatisfactoriamente() {
        Persona carlos = builder
                .carlos()
                .build();
        Mockito.when(this.respository.crearPersona(carlos)).thenReturn(carlos);

        Persona carlosResult = service.crearPersona(carlos);

        assertEquals(carlosResult, carlos);
    }

    @Test
    void crearPersonaDebeArrojarUnErrorCuandoSeCreaUnaPersonaConNombreNull() {
        Persona carlos = builder
                .carlos()
                .withNombre(null)
                .build();

        try {
            service.crearPersona(carlos);
            fail();
        } catch(RuntimeException err) {
            assertTrue(err.getMessage().contains("El nombre es obligatorio"));
        }
    }

    @Test
    void crearPersonaDebeArrojarUnErrorCuandoSeCreaUnaPersonaConNombreVacio() {
        Persona carlos = builder
                .carlos()
                .withNombre("")
                .build();

        assertThrows(RuntimeException.class, () -> service.crearPersona(carlos));
    }


    @Test
    void listarPersonasDebeRetornarCarlosYDavidCuandoSeAgregaronPreviamente() {
        // Arrange
        List<Persona> expectedListaPersona = new ArrayList<>();
        Mockito.when(this.respository.listarPersonas()).thenReturn(expectedListaPersona);

        // Act
        List<Persona> listaPersonasResult = service.listarPersonas();

        // Assert
        assertSame(expectedListaPersona, listaPersonasResult);
    }

    @Test
    void getPersonaPorIdSeObtieneCorrectamenteUnaPersonaPorId(){
        // Arrange
        Persona carlos = builder
                .carlos()
                .build();
        //service.crearPersona(carlos);
        Mockito.when(this.respository.getPersonaPorId(carlos.getCedula())).thenReturn(Optional.of(carlos));

        // Act
        Persona result = service.getPersonaPorId(carlos.getCedula());

        // Assert
        assertSame(carlos, result);
    }


    @Test
    void getPersonaPorIdLanzaMakaiaApiExceptionCuandoNoExisteElId(){
        // Arrange
        String cedula = "123455";
        Mockito
                .when(this.respository.getPersonaPorId(cedula))
                .thenReturn(Optional.empty());

        // Assert
        assertThrows(MakaiaApiException.class,
                ()->
                        // Act
                        service.getPersonaPorId(cedula)
                );
    }

    // Caso exitoso
    // Caso de una lista vacía
    // Caso de un id malo
}