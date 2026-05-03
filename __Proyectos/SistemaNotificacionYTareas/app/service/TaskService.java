package __Proyectos.SistemaNotificacionYTareas.app.service;

import __Proyectos.SistemaNotificacionYTareas.app.annotation.Auditable;
import __Proyectos.SistemaNotificacionYTareas.app.dto.NotificationResponseDTO;
import __Proyectos.SistemaNotificacionYTareas.app.dto.TaskRequestDTO;
import __Proyectos.SistemaNotificacionYTareas.app.dto.TaskResponseDTO;
import __Proyectos.SistemaNotificacionYTareas.app.model.Notification;
import __Proyectos.SistemaNotificacionYTareas.app.model.Task;
import __Proyectos.SistemaNotificacionYTareas.app.repository.TaskRepository;

import java.util.List;
import java.util.stream.Collectors;

public class TaskService {
    private final TaskRepository taskRepository;
    private final NotificationService notificationService;
    public TaskService(TaskRepository taskRepository, NotificationService notificationService) {
        this.taskRepository = taskRepository;
        this.notificationService = notificationService;
    }

    @Auditable(action="CREATE_TASK")
    public TaskResponseDTO create(TaskRequestDTO taskRequestDTO) {
        validate(taskRequestDTO);
        Task task = new Task(
          null,
          taskRequestDTO.title(),
          taskRequestDTO.description(),
          taskRequestDTO.priority()
        );
        Task saved = taskRepository.save(task);
        return mapToDTO(saved);
    }

    @Auditable(action = "COMPLETE_TASK")
    public TaskResponseDTO complete(Long taskId) {
        Task task = taskRepository.findById(taskId).orElseThrow(()-> new RuntimeException("Tarea no encontrada"));
        task.complete();
        taskRepository.save(task);
        return mapToDTO(task);
    }

    public List<TaskResponseDTO> listTasks() {
        return taskRepository.findAll().stream().
        map(this::mapToDTO).
                collect(Collectors.toList());
    }

    public NotificationResponseDTO notifuTask(Long taskId, Notification notification) {
        Task task = taskRepository.findById(taskId).orElseThrow(()-> new RuntimeException("Tarea no encontrada"));
        task.addNotification(notification);
        taskRepository.save(task);
        return notificationService.process(notification);
    }

    private void validate(TaskRequestDTO taskRequestDTO) {
        if(taskRequestDTO.title()==null || taskRequestDTO.title().isBlank()) throw new RuntimeException("El titulo es obligatorio");
        if(taskRequestDTO.description()==null || taskRequestDTO.description().isBlank()) throw new RuntimeException("La descripcion es obligatorio");
        if(taskRequestDTO.priority()==null) throw new RuntimeException("La prioridad es obligatorio");
    }

    private TaskResponseDTO mapToDTO(Task task){
        return new TaskResponseDTO(
                task.getId(),
                task.getTitle(),
                task.getPriority().displayName(),
                task.getStatus().label()
        );
    }
}
