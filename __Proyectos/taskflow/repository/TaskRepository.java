package __Proyectos.taskflow.repository;

import __Proyectos.taskflow.model.Task;

import java.util.*;

public class TaskRepository implements CrudRepository<Task,Long>{
    private final Map<Long,Task> db = new HashMap<>();
    private long sequence = 1L;

    @Override
    public Task save(Task task) {
        if(task.getId()==null) task.setId(sequence++);
        db.put(task.getId(),task);
        return task;
    }

    @Override
    public Optional<Task> findById(Long id) {
        return Optional.ofNullable(db.get(id));
    }

    @Override
    public List<Task> findAll() {
        return new ArrayList<>(db.values());
    }
}
