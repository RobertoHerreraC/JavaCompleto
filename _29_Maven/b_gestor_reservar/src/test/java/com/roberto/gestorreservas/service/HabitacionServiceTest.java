package com.roberto.gestorreservas.service;

import com.roberto.gestorreservas.domain.Habitacion;
import com.roberto.gestorreservas.enums.EstadoHabitacion;
import com.roberto.gestorreservas.exception.HabitacionNoEncontradaException;
import com.roberto.gestorreservas.repository.HabitacionRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class HabitacionServiceTest {
    @Test
    void deberiaRegistrarHabitacionValida() {
        HabitacionRepository repository = new HabitacionRepository();
        HabitacionService service = new HabitacionService(repository);

        Habitacion habitacion = new Habitacion(
                1L,
                "101",
                2,
                EstadoHabitacion.DISPONIBLE
        );

        service.registrar(habitacion);

        assertEquals(1, service.listarTodas().size());
    }

    @Test
    void deberiaLanzarErrorCuandoCapacidadEsInvalida() {
        HabitacionRepository repository = new HabitacionRepository();
        HabitacionService service = new HabitacionService(repository);

        Habitacion habitacion = new Habitacion(
                1L,
                "101",
                0,
                EstadoHabitacion.DISPONIBLE
        );

        assertThrows(
                IllegalArgumentException.class,
                () -> service.registrar(habitacion)
        );
    }

    @Test
    void deberiaBuscarHabitacionPorNumero() {
        HabitacionRepository repository = new HabitacionRepository();
        HabitacionService service = new HabitacionService(repository);

        service.registrar(new Habitacion(
                1L,
                "101",
                2,
                EstadoHabitacion.DISPONIBLE
        ));

        Habitacion resultado = service.buscarPorNumero("101");

        assertEquals("101", resultado.numero());
    }

    @Test
    void deberiaLanzarErrorCuandoHabitacionNoExiste() {
        HabitacionRepository repository = new HabitacionRepository();
        HabitacionService service = new HabitacionService(repository);

        assertThrows(
                HabitacionNoEncontradaException.class,
                () -> service.buscarPorNumero("999")
        );
    }

    @Test
    void deberiaListarSoloHabitacionesDisponibles() {
        HabitacionRepository repository = new HabitacionRepository();
        HabitacionService service = new HabitacionService(repository);

        service.registrar(new Habitacion(1L, "101", 2, EstadoHabitacion.DISPONIBLE));
        service.registrar(new Habitacion(2L, "102", 4, EstadoHabitacion.OCUPADA));
        service.registrar(new Habitacion(3L, "103", 1, EstadoHabitacion.DISPONIBLE));

        assertEquals(2, service.listarDisponibles().size());
    }
}
