package com.roberto.gestorreservas.repository;

import com.roberto.gestorreservas.domain.Habitacion;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class HabitacionRepository {
    private final List<Habitacion> habitaciones = new ArrayList<>();

    public void guardar(Habitacion habitacion) {
        habitaciones.add(habitacion);
    }

    public Optional<Habitacion> buscarPorNumero(String numero) {
        return habitaciones.stream()
                .filter(habitacion -> habitacion.numero().equals(numero))
                .findFirst();
    }

    public List<Habitacion> listar() {
        return List.copyOf(habitaciones);
    }
}
