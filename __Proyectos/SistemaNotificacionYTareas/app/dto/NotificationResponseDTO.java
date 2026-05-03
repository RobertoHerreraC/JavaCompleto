package __Proyectos.SistemaNotificacionYTareas.app.dto;

public record NotificationResponseDTO(
        String type,
        String recipient,
        String summary
) {
}
