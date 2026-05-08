package __Proyectos._09_JobTrackAsincrona.controller;

import __Proyectos._09_JobTrackAsincrona.dto.JobCreateDTO;
import __Proyectos._09_JobTrackAsincrona.model.EmailPayload;
import __Proyectos._09_JobTrackAsincrona.model.FilePayload;
import __Proyectos._09_JobTrackAsincrona.model.JobPriority;
import __Proyectos._09_JobTrackAsincrona.model.JobType;
import __Proyectos._09_JobTrackAsincrona.service.JobProcessorService;
import __Proyectos._09_JobTrackAsincrona.service.JobService;
import __Proyectos._09_JobTrackAsincrona.service.ReportService;

public class JobController {
    private final JobService jobService;
    private final JobProcessorService processorService;
    private final ReportService reportService;

    public JobController(
            JobService jobService,
            JobProcessorService processorService,
            ReportService reportService
    ){
        this.jobService = jobService;
        this. processorService = processorService;
        this. reportService = reportService;
    }

    public void createEmailJob(String name, String recipient, JobPriority priority){
        JobCreateDTO dto = new JobCreateDTO(
                name,
                JobType.EMAIL,
                priority,
                new EmailPayload(recipient, "Alerta", "Mensaje de prueba")
        );
        System.out.println("Creado: "+ jobService.create(dto));
    }

    public void createFileJob(String name, String fileName, String content){
        JobCreateDTO dto = new JobCreateDTO(
                name,
                JobType.FILE,
                JobPriority.MEDIUM,
                new FilePayload(fileName, content)
        );
        System.out.println("Creado: "+jobService.create(dto));
    }

    public void listJobs(){
        jobService.findAll().forEach(System.out::println);
    }

    public void processPending(){
        processorService.processPendingJobs();
    }

    public void exportReport(){
        reportService.exportReport("jobtrack.report.txt");
    }

}
