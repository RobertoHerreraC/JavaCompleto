package __Proyectos._09_JobTrackAsincrona.repository;

import __Proyectos._09_JobTrackAsincrona.model.Job;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class JobRepository implements CrudRepository<Job,Long>{
    private final ConcurrentHashMap<Long, Job> db = new ConcurrentHashMap<>();
    private final AtomicLong sequence = new AtomicLong(1);

    @Override
    public Job save(Job job) {
        if(job.getId()==null){
            job.setId(sequence.getAndIncrement());
        }
        db.put(job.getId(),job);
        return job;
    }

    @Override
    public Optional<Job> findBtId(Long id) {
        return Optional.ofNullable(db.get(id));
    }

    @Override
    public List<Job> findAll() {
        return new ArrayList<>(db.values());
    }
}
