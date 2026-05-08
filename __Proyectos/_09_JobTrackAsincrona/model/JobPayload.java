package __Proyectos._09_JobTrackAsincrona.model;

public sealed interface JobPayload permits EmailPayload, FilePayload, BackupPayload{
}
