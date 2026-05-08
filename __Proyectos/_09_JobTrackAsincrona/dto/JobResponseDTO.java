package __Proyectos._09_JobTrackAsincrona.dto;

public record JobResponseDTO(
        Long id,
        String name,
        String type,
        String priority,
        String status,
        int attempts
) {
}
