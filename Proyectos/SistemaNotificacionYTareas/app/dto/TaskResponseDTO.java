package Proyectos.SistemaNotificacionYTareas.app.dto;

public record TaskResponseDTO(
        Long id,
        String title,
        String priority,
        String status
) {
}
