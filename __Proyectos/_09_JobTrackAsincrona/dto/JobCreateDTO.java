package __Proyectos._09_JobTrackAsincrona.dto;

import __Proyectos._09_JobTrackAsincrona.model.JobPayload;
import __Proyectos._09_JobTrackAsincrona.model.JobPriority;
import __Proyectos._09_JobTrackAsincrona.model.JobType;

public record JobCreateDTO(
        String name,
        JobType type,
        JobPriority priority,
        JobPayload payload
) {
}
