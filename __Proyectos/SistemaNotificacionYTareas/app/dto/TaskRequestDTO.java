package __Proyectos.SistemaNotificacionYTareas.app.dto;

import __Proyectos.SistemaNotificacionYTareas.app.model.Priority;

public record TaskRequestDTO(
        String title,
        String description,
        Priority priority
) {
}
