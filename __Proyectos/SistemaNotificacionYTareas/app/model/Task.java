package __Proyectos.SistemaNotificacionYTareas.app.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Task {
    private Long id;
    private String title;
    private String description;
    private Priority priority;
    private TaskStatus status;
    private final LocalDateTime createdAt;
    private final List<Notification> notifications = new ArrayList<>();

    public Task(Long id, String title, String description, Priority priority) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.status = TaskStatus.PENDING;
        this.createdAt = LocalDateTime.now();

    }

    public void complete(){
        if(status==TaskStatus.COMPLETED) throw new RuntimeException("La tarea ya esta completada");
        this.status = TaskStatus.COMPLETED;
    }

    public void addNotification(Notification notification) {
        notifications.add(notification);
    }
    public Long getId(){return id;}
    public void setId(Long id){this.id = id;}
    public String getTitle(){return title;}
    public String getDescription(){return description;}
    public Priority getPriority(){return priority;}
    public TaskStatus getStatus(){return status;}
    public LocalDateTime getCreatedAt(){return createdAt;}
    public List<Notification> getNotifications(){return notifications;}
}
