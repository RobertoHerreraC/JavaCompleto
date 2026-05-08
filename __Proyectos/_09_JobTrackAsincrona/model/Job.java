package __Proyectos._09_JobTrackAsincrona.model;

import __Proyectos._09_JobTrackAsincrona.exception.BusinessException;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicInteger;

public class Job {
    private Long id;
    private String name;
    private JobType type;
    private JobPriority priority;
    private JobStatus status;
    private JobPayload payload;
    private AtomicInteger attempts;
    private LocalDateTime createdAt;
    private LocalDateTime processedAt;
    private String errorMessage;

    public Job(Long id, String name, JobType type, JobPriority priority,
               JobPayload payload){
        this.id = id;
        this.name = name;
        this.type = type;
        this.priority = priority;
        this.payload = payload;
        this.status = JobStatus.PENDING;
        this.attempts = new AtomicInteger(0);
        this.createdAt = LocalDateTime.now();
    }

    public void startProcessing(){
        if(!status.canProcess()) throw new BusinessException("El job no puede procesarse en estado: "+status);

        status = JobStatus.PROCESSING;
        attempts.incrementAndGet();
    }

    public void marjkCompleted(){
        status = JobStatus.COMPLETED;
        processedAt = LocalDateTime.now();
        errorMessage = null;
    }

    public void markFailed(String errorMessage){
        status = JobStatus.FAILED;
        processedAt = LocalDateTime.now();
        this.errorMessage = errorMessage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public JobType getType() {
        return type;
    }

    public JobPriority getPriority() {
        return priority;
    }

    public JobStatus getStatus() {
        return status;
    }

    public JobPayload getPayload() {
        return payload;
    }

    public int getAttempts() {
        return attempts.get();
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getProcessedAt() {
        return processedAt;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
