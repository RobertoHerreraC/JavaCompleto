package __Proyectos._09_JobTrackAsincrona;

import __Proyectos._09_JobTrackAsincrona.controller.JobController;
import __Proyectos._09_JobTrackAsincrona.model.JobPriority;
import __Proyectos._09_JobTrackAsincrona.repository.JobRepository;
import __Proyectos._09_JobTrackAsincrona.service.AuditService;
import __Proyectos._09_JobTrackAsincrona.service.JobProcessorService;
import __Proyectos._09_JobTrackAsincrona.service.JobService;
import __Proyectos._09_JobTrackAsincrona.service.ReportService;
import __Proyectos._09_JobTrackAsincrona.util.ReportFileWriter;

public class Main {
    static void main() {
        JobRepository repository = new JobRepository();

        JobService jobService = new JobService(repository);
        JobProcessorService processorService = new JobProcessorService(jobService);
        ReportFileWriter fileWriter = new ReportFileWriter();
        ReportService reportService = new ReportService(jobService, fileWriter);
        AuditService auditService = new AuditService();

        JobController controller = new JobController(
                jobService,
                processorService,
                reportService
        );

        controller.createEmailJob(
                "Enviar correo de bienvenida",
                "roberto@gmail.com",
                JobPriority.HIGH
        );

        controller.createFileJob(
                "Procesar archivos de usuario",
                "user.txt",
                "Roberto, Kateryn, Ingrid"
        );

        controller.createFileJob(
                "Procesar archivo vacio",
                "empty.txt",
                ""
        );

        controller.listJobs();
        controller.exportReport();
        controller.processPending();

        controller.listJobs();

        auditService.printAuditableMethods(jobService);
        auditService.printAuditableMethods(processorService);
        controller.exportReport();


    }
}
