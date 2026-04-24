package Proyectos.taskflow.service;

import Proyectos.taskflow.annotation.Auditable;
import Proyectos.taskflow.dto.CommentDTO;
import Proyectos.taskflow.dto.NotificationResultDTO;
import Proyectos.taskflow.dto.TaskCreateDTO;
import Proyectos.taskflow.dto.TaskResponseDTO;
import Proyectos.taskflow.model.*;
import Proyectos.taskflow.repository.TaskRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TaskService {
    private final TaskRepository repository;
    private final NotificationService notificationService;

    public TaskService(TaskRepository repository, NotificationService notificationService) {
        this.repository = repository;
        this.notificationService = notificationService;
    }

    @Auditable(action="CREATE_TASK")
    public TaskResponseDTO create(TaskCreateDTO dto) {
        validate(dto);
        Task task = switch (dto.type().toUpperCase()){
            case "STANDARD" -> new StandardTask(null,dto.title(),dto.description(),dto.priority());
            case "URGENT" -> new UrgentTask(null,dto.title(),dto.description(),dto.priority());
            case "BLOCKED" -> new BlockedTask(null,dto.title(),dto.description(),dto.priority());
            default -> throw new RuntimeException("Tipo de tarea invalido");
        };
        Task saved =repository.save(task);
        return toResponseDTO(saved);
    }

    @Auditable(action = "COMPLETE_TASK")
    public TaskResponseDTO complete(Long id){
        Task task = repository.findById(id).orElseThrow(()->new RuntimeException("Tarea no encontrada"));
        task.complete();
        repository.save(task);
        return toResponseDTO(task);
    }

    public TaskResponseDTO start(Long id){
        Task task = repository.findById(id).orElseThrow(()->new RuntimeException("Tarea no encontrada"));
        task.start();
        repository.save(task);
        return toResponseDTO(task);
    }

    public NotificationResultDTO notifyTask(Long id, Notification notification){
        Task task = repository.findById(id).orElseThrow(()->new RuntimeException("Tarea no encontrada"));
        return notificationService.send(notification);
    }

    public TaskResponseDTO addComment(Long id, CommentDTO dto){
        Task task = repository.findById(id).orElseThrow(()->new RuntimeException("Tarea no encontrada"));
        task.addComment(new Comment(dto.author(),dto.message(), LocalDateTime.now()));
        repository.save(task);
        return toResponseDTO(task);
    }

    public List<TaskResponseDTO> findAll(){
        return repository.findAll().stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    public List<TaskResponseDTO> findByStatus(TaskStatus status){
        return repository.findAll()
                .stream()
                .filter(t -> t.getStatus().equals(status))
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    public List<TaskResponseDTO>  findCriticalOrHigh(){
        return repository.findAll()
                .stream()
                .filter(t->t.getPriority().level() >= Priority.HIGH.level())
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    public Map<TaskStatus,Long> summaryByStatus(){
        return repository.findAll()
                .stream()
                .collect(Collectors.groupingBy(
                        Task::getStatus,
                        Collectors.counting()
                ));
    }

    private TaskResponseDTO toResponseDTO(Task task){
        return new TaskResponseDTO(
                task.getId(),
                task.getTitle(),
                task.typeName(),
                task.getPriority().displayName(),
                task.getStatus().label(),
                task.getComments().size()
        );
    }

    private void validate(TaskCreateDTO dto){
        if(dto.title()==null || dto.title().isBlank()){
            throw new RuntimeException("El titulo es obligatorio");
        }
        if(dto.description()==null || dto.description().isBlank()){
            throw new RuntimeException("El descripcion es obligatoria");
        }
        if(dto.priority()==null){
            throw new RuntimeException("El prioridad es obligatoria");
        }
        if(dto.type()==null || dto.type().isBlank()){
            throw new RuntimeException("El tipo es obligatorio");
        }
    }
}
