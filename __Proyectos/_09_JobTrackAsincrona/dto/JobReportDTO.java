package __Proyectos._09_JobTrackAsincrona.dto;

public record JobReportDTO(
        long total,
        long pending,
        long processing,
        long completed,
        long failed
) {
}
