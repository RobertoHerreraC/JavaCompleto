package __Proyectos._09_JobTrackAsincrona.model;

public record BackupPayload(
        String sourcePath,
        String targetPath
) implements JobPayload{
}
