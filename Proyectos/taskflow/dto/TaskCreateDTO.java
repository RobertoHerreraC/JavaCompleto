package Proyectos.taskflow.dto;

import Proyectos.taskflow.model.Priority;

public record TaskCreateDTO(
        String title,
        String description,
        Priority priority,
        String type
) {
}
