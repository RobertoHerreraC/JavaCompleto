package __Proyectos._09_JobTrackAsincrona.service;

import __Proyectos._09_JobTrackAsincrona.dto.JobCreateDTO;
import __Proyectos._09_JobTrackAsincrona.dto.JobResponseDTO;
import __Proyectos._09_JobTrackAsincrona.exception.BusinessException;
import __Proyectos._09_JobTrackAsincrona.exception.JobNotFoundException;
import __Proyectos._09_JobTrackAsincrona.model.Job;
import __Proyectos._09_JobTrackAsincrona.model.JobStatus;
import __Proyectos._09_JobTrackAsincrona.repository.JobRepository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class JobService {
    private final JobRepository repository;

    public JobService(JobRepository repository){
        this.repository = repository;
    }

    public JobResponseDTO create(JobCreateDTO dto){
        validate(dto);
        Job job = new Job(
                null,
                dto.name(),
                dto.type(),
                dto.priority(),
                dto.payload()
        );

        return mapToDTO(repository.save(job));
    }

    public Job findEntityById(Long id){
        return repository.findBtId(id)
                .orElseThrow(()-> new JobNotFoundException(id));
    }

    public List<JobResponseDTO> findAll(){
        return repository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public List<Job> findPendingEntities(){
        return repository.findAll()
                .stream()
                .filter(j -> j.getStatus()== JobStatus.PENDING)
                .sorted((a,b)-> Integer.compare(
                        b.getPriority().level(),
                        a.getPriority().level()))
                .collect(Collectors.toList());
    }

    public Map<JobStatus,Long> summaryByStatus(){
        return repository.findAll()
                .stream()
                .collect(Collectors.groupingBy(
                        job -> job.getStatus(),
                        Collectors.counting()
                ));
    }

    public Job save(Job job){
        System.out.println("Antes de save");
        return repository.save(job);
    }

    private JobResponseDTO mapToDTO(Job job){
        return new JobResponseDTO(
                job.getId(),
                job.getName(),
                job.getType().name(),
                job.getPriority().descrption(),
                job.getStatus().label(),
                job.getAttempts()
        );
    }

    private void validate(JobCreateDTO dto){
        if(dto.name()==null || dto.name().isBlank()) throw new BusinessException("El nombre del job es obligatorio");

        if(dto.type()==null) throw new BusinessException("El tipo es obligatorio");

        if(dto.priority()==null) throw new BusinessException("La prioridad es obligatoria");

        if(dto.payload()==null) throw new BusinessException("El payload es obligatoria");
    }
}
