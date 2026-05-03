package __Proyectos.taskflow.model;

public final class BlockedTask extends Task {
    public BlockedTask(Long id, String title, String description, Priority priority) {
        super(id,title,description,priority);
    }
    @Override
    public String typeName() {
        return "BLOCKED";
    }
}
