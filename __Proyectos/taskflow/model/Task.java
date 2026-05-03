package __Proyectos.taskflow.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public abstract sealed class Task permits StandardTask, UrgentTask, BlockedTask{
    private Long id;
    private final String title;
    private final String description;
    private final Priority priority;
    private TaskStatus status;
    private final LocalDateTime createdAt;
    private final List<Comment> comments = new ArrayList<>();
    private final List<String> tags = new ArrayList<>();

    protected Task(Long id, String title, String description, Priority priority){
        this.id = id;
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.status = TaskStatus.PENDING;
        this.createdAt = LocalDateTime.now();
    }

    public void complete(){
        if(status ==TaskStatus.COMPLETED) throw new RuntimeException("La tarea ya fue completada");
        status = TaskStatus.COMPLETED;
    }

    public void block(){
        if(status==TaskStatus.COMPLETED) throw new  RuntimeException("No puedes bloquear una tarea completada");
        status = TaskStatus.BLOCKED;
    }

    public void start(){
        if(status==TaskStatus.COMPLETED) throw new  RuntimeException("La tarea ya esta completada");
        status = TaskStatus.IN_PROGRESS;
    }

    public void addComment(Comment comment){
        comments.add(comment);
    }

    public void addTag(String tag){
        if(tag!=null && !tag.isBlank()) tags.add(tag);
    }
    public abstract String typeName();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<String> getTags() {
        return tags;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public Priority getPriority() {
        return priority;
    }

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }
}
