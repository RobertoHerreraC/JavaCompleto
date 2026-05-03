package __Proyectos.taskflow.model;

public final class StandardTask extends Task {


    public StandardTask(Long id, String title, String description, Priority priority) {
        super(id, title, description, priority);
    }

    @Override
    public String typeName() {
        return "STANDARD";
    }
}
