package __Proyectos._09_JobTrackAsincrona.service;

import __Proyectos._09_JobTrackAsincrona.dto.JobReportDTO;
import __Proyectos._09_JobTrackAsincrona.model.JobStatus;
import __Proyectos._09_JobTrackAsincrona.util.ReportFileWriter;

import java.util.Map;

public class ReportService {
    private final JobService jobService;
    private final ReportFileWriter fileWriter;

    public ReportService(JobService jobService, ReportFileWriter fileWriter){
        this.fileWriter = fileWriter;
        this.jobService = jobService;
    }

    public JobReportDTO generateReport(){
        Map<JobStatus,Long> summary = jobService.summaryByStatus();

        return new JobReportDTO(
                summary.values().stream().mapToLong(Long::longValue).sum(),
                summary.getOrDefault(JobStatus.PENDING,0L),
                summary.getOrDefault(JobStatus.PROCESSING,0L),
                summary.getOrDefault(JobStatus.COMPLETED,0L),
                summary.getOrDefault(JobStatus.FAILED,0L)
        );
    }

    public void exportReport(String fileName){
        JobReportDTO report = generateReport();

        String content = """
                ============== JOBTRACK REPORT ==============
                Total               : %d
                Pendientes          : %d
                Procesando          : %d
                Completados         : %d
                Fallidos            : %d
                =============================================
                """.formatted(report.total(),
                report.pending(),
                report.processing(),
                report.completed(),
                report.failed());

        fileWriter.write(fileName,content);
    }
}
