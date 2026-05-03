package __Proyectos.taskflow.dto;

import __Proyectos.taskflow.model.Priority;

public record TaskCreateDTO(
        String title,
        String description,
        Priority priority,
        String type
) {
}
