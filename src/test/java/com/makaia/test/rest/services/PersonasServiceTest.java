package com.makaia.test.rest.services;

import com.makaia.test.rest.builders.PersonaBuilder;
import com.makaia.test.rest.exceptions.MakaiaApiException;
import com.makaia.test.rest.models.Persona;
import com.makaia.test.rest.repositories.PersonaRespository;
import org.junit.jupiter.api.*;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.mock.*;

import java.util.List;

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

        service.crearPersona(carlos);

        List<Persona> personas = service.listarPersonas();
        boolean carlosExiste = personas.contains(carlos);
        assertTrue(carlosExiste);
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
        int expectedListSize = 2;
        Persona carlos = builder
                .carlos()
                .build();
        Persona david = builder
                .withNombre("David")
                .withApellido("De los Rios")
                .withCedula("52345623")
                .withCiudad("Medellín")
                .build();

        service.crearPersona(carlos);
        service.crearPersona(david);

        // Act
        List<Persona> listaPersonas = service.listarPersonas();

        // Assert
        assertTrue(listaPersonas.contains(carlos));
        assertTrue(listaPersonas.contains(david));
        assertEquals(expectedListSize, listaPersonas.size());
    }

    @Test
    void getPersonaPorIdSeObtieneCorrectamenteUnaPersonaPorId(){
        // Arrange
        Persona carlos = builder
                .carlos()
                .build();
        service.crearPersona(carlos);

        // Act
        Persona result = service.getPersonaPorId(carlos.getCedula());

        // Assert
        assertEquals(carlos, result);
    }


    @Test
    void getPersonaPorIdLanzaMakaiaApiExceptionCuandoNoExisteElId(){
        // Arrange

        // Assert
        assertThrows(MakaiaApiException.class,
                ()->
                        // Act
                        service.getPersonaPorId("123455")
                );
    }

    // Caso exitoso
    // Caso de una lista vacía
    // Caso de un id malo
}