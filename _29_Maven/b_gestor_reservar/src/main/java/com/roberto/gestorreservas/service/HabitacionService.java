package com.roberto.gestorreservas.service;

import com.roberto.gestorreservas.domain.Habitacion;
import com.roberto.gestorreservas.enums.EstadoHabitacion;
import com.roberto.gestorreservas.exception.HabitacionNoEncontradaException;
import com.roberto.gestorreservas.repository.HabitacionRepository;

import java.util.List;

public class HabitacionService {
    private final HabitacionRepository repository;

    public HabitacionService(HabitacionRepository repository) {
        this.repository = repository;
    }

    public void registrar(Habitacion habitacion) {
        validarHabitacion(habitacion);
        repository.guardar(habitacion);
    }

    public Habitacion buscarPorNumero(String numero) {
        return repository.buscarPorNumero(numero)
                .orElseThrow(() -> new HabitacionNoEncontradaException(
                        "No existe habitación con número: " + numero
                ));
    }

    public List<Habitacion> listarDisponibles() {
        return repository.listar().stream()
                .filter(habitacion -> habitacion.estado() == EstadoHabitacion.DISPONIBLE)
                .toList();
    }

    public List<Habitacion> listarTodas() {
        return repository.listar();
    }

    private void validarHabitacion(Habitacion habitacion) {
        if (habitacion.numero() == null || habitacion.numero().isBlank()) {
            throw new IllegalArgumentException("El número de habitación es obligatorio");
        }

        if (habitacion.capacidad() <= 0 || habitacion.capacidad() > 10) {
            throw new IllegalArgumentException("La capacidad debe estar entre 1 y 10");
        }

        if (habitacion.estado() == null) {
            throw new IllegalArgumentException("El estado de la habitación es obligatorio");
        }
    }
}
