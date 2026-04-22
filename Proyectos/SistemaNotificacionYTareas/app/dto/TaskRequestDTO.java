package Proyectos.SistemaNotificacionYTareas.app.dto;

import Proyectos.SistemaNotificacionYTareas.app.model.Priority;

public record TaskRequestDTO(
        String title,
        String description,
        Priority priority
) {
}
