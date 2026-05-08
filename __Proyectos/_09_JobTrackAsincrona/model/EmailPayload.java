package __Proyectos._09_JobTrackAsincrona.model;

public record EmailPayload(
        String recipient,
        String subject,
        String body
) implements JobPayload{
}
