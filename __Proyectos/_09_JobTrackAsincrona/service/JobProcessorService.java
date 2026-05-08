package __Proyectos._09_JobTrackAsincrona.service;

import __Proyectos._08_taskflow.annotation.Auditable;
import __Proyectos._09_JobTrackAsincrona.dto.JobResponseDTO;
import __Proyectos._09_JobTrackAsincrona.exception.BusinessException;
import __Proyectos._09_JobTrackAsincrona.model.BackupPayload;
import __Proyectos._09_JobTrackAsincrona.model.EmailPayload;
import __Proyectos._09_JobTrackAsincrona.model.FilePayload;
import __Proyectos._09_JobTrackAsincrona.model.Job;

import java.util.List;
import java.util.concurrent.*;

public class JobProcessorService {
    private final JobService jobService;
    private final Semaphore semaphore = new Semaphore(3);
    private volatile boolean running = true;

    public JobProcessorService(JobService jobService){
        this.jobService = jobService;
    }

    @Auditable(action = "PROCESS_PENDING_JOBS")
    public void processPendingJobs(){
        List<Job> pendingJobs = jobService.findPendingEntities();

        if(pendingJobs.isEmpty()){
            System.out.println("No hay jobs pendientes para procesar");
            return;
        }
        CountDownLatch latch = new CountDownLatch(pendingJobs.size());
        try(ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()){

            for(Job job : pendingJobs){
                executor.submit(()->{
                    //boolean acquired = false;
                   try{
                       semaphore.acquire();
                       //acquired = true;
                       processSingleJob(job);
                   }catch (InterruptedException e){
                       Thread.currentThread().interrupt();
                       job.markFailed("Proceso interrumpido");
                       jobService.save(job);
                   }catch (Exception e){
                       job.markFailed("Error procesando job: "+ e.getMessage());
                       jobService.save(job);
                   }finally {
                       //if(acquired)
                       semaphore.release();
                       latch.countDown();
                   }
                });
            }
            boolean finished = latch.await(30, TimeUnit.SECONDS);
            if(!finished) throw new RuntimeException("Timeout: algunos jobs no terminaron a tiempo.");
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
            throw new BusinessException("Procesamiento interrumpido");
        }
    }

    public CompletableFuture<JobResponseDTO> processAsync(Long jobId){
        return CompletableFuture.supplyAsync(()->{
            Job job = jobService.findEntityById(jobId);
            processSingleJob(job);
            return new JobResponseDTO(
                    job.getId(),
                    job.getName(),
                    job.getType().name(),
                    job.getPriority().descrption(),
                    job.getStatus().label(),
                    job.getAttempts()
            );
        });
    }

    private void processSingleJob(Job job){
        if(!running) throw new BusinessException("El procesador esta detenido");

        try{
            job.startProcessing();
            String result = switch(job.getPayload()){
                case EmailPayload email -> processEmail(email);
                case FilePayload file -> processFile(file);
                case BackupPayload backup -> processBackup(backup);
            };
            System.out.println(result);
            job.marjkCompleted();
            System.out.println("1");
        }catch (Exception e){
            job.markFailed("Fallback aplicado: "+e.getMessage());
        }finally {
            jobService.save(job);
        }
    }

    private String processEmail(EmailPayload email){
        return "Email enviado a: "+email.recipient();
    }

    private String processFile(FilePayload file){
        if(file.content().isBlank()) throw new BusinessException("Archivo sin contenido");
        return "Archivo precesado: "+file.fileName();
    }

    private String processBackup(BackupPayload backup){
        return "Backup desde "+backup.sourcePath() + " hacia " + backup.targetPath();
    }

    public void stop(){
        running = false;
    }
}
