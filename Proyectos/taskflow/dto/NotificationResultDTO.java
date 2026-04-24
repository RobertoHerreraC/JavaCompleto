package Proyectos.taskflow.dto;

public record NotificationResultDTO(
        String channel,
        String recipient,
        String result
) {
}
