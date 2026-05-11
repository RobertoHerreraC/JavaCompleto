package com.roberto.gestorreservas;

import com.roberto.gestorreservas.domain.Habitacion;
import com.roberto.gestorreservas.enums.EstadoHabitacion;
import com.roberto.gestorreservas.repository.HabitacionRepository;
import com.roberto.gestorreservas.service.HabitacionService;

public class App {
    static void main() {
        HabitacionRepository repository = new HabitacionRepository();
        HabitacionService service = new HabitacionService(repository);

        service.registrar(new Habitacion(1L, "101", 2, EstadoHabitacion.DISPONIBLE));
        service.registrar(new Habitacion(2L, "102", 4, EstadoHabitacion.OCUPADA));
        service.registrar(new Habitacion(3L, "103", 1, EstadoHabitacion.DISPONIBLE));

        System.out.println("Habitaciones disponibles:");

        service.listarDisponibles()
                .forEach(System.out::println);

        System.out.println("Buscar habitación 101:");
        System.out.println(service.buscarPorNumero("101"));
    }
}
