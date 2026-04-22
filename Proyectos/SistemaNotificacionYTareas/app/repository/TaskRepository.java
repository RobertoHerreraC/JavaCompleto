package Proyectos.SistemaNotificacionYTareas.app.repository;

import Proyectos.SistemaNotificacionYTareas.app.model.Task;

import java.util.*;

public class TaskRepository implements CrudRepository<Task,Long>{
    private final Map<Long,Task> db = new HashMap<>();
    private long sequence = 1L;

    @Override
    public Task save(Task entity) {
        if(entity.getId()==null) entity.setId(sequence++);
        db.put(entity.getId(),entity);
        return entity;
    }

    @Override
    public Optional<Task> findById(Long aLong) {
        return Optional.ofNullable(db.get(aLong));
    }

    @Override
    public List<Task> findAll() {
        return new ArrayList<>(db.values());
    }
}
