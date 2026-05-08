package __Proyectos._09_JobTrackAsincrona.model;

public record FilePayload(
        String fileName,
        String content
) implements JobPayload {
}
