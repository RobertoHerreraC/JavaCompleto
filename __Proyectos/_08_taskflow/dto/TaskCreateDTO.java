package __Proyectos._08_taskflow.dto;

import __Proyectos._08_taskflow.model.Priority;

public record TaskCreateDTO(
        String title,
        String description,
        Priority priority,
        String type
) {
}
