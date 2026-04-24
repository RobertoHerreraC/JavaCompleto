package Proyectos.taskflow.dto;

public record TaskResponseDTO(
        Long id,
        String title,
        String type,
        String priority,
        String status,
        long commentsCount
) {
}
