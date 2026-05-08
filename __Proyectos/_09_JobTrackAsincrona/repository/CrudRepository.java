package __Proyectos._09_JobTrackAsincrona.repository;

import java.util.List;
import java.util.Optional;

public interface CrudRepository<T, ID> {
    T save(T entity);
    Optional<T> findBtId(ID id);
    List<T> findAll();
}
