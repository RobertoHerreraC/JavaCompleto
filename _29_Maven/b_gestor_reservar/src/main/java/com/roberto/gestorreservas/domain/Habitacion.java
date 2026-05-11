package com.roberto.gestorreservas.domain;

import com.roberto.gestorreservas.enums.EstadoHabitacion;

public record Habitacion(
        Long id,
        String numero,
        int capacidad,
        EstadoHabitacion estado
) {
}
