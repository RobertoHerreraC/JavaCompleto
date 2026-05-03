package __Proyectos.taskflow.model;

public final class UrgentTask extends Task{

    public UrgentTask(Long id, String title, String description,Priority priority){
        super(id, title, description, priority);
    }
    @Override
    public String typeName() {
        return "URGENT";
    }
}
