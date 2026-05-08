package __Proyectos._09_JobTrackAsincrona.util;

import __Proyectos._09_JobTrackAsincrona.model.EmailPayload;
import __Proyectos._09_JobTrackAsincrona.model.Job;
import __Proyectos._09_JobTrackAsincrona.model.JobPriority;
import __Proyectos._09_JobTrackAsincrona.model.JobType;

import java.util.List;

public class JobPrinter {
    public static void printNames(List<? extends Job> jobs){
        jobs.forEach(job -> System.out.println(job.getName()));
    }

    public static void addDefaultJobs(List<? super Job> jobs){
        jobs.add(new Job(
                null,
                "Job por defecto",
                JobType.EMAIL,
                JobPriority.LOW,
                new EmailPayload("default@mail.com","Default", "Mensaje default")
                )
        );
    }
}
