package Proyectos.GestionUsuarios.app.repository;

import Proyectos.GestionUsuarios.app.model.User;

import java.util.*;

public class UserRepository {

    private Map<Long, User> db = new HashMap<>();
    private Long idCounter = 1L;

    public User save(User user){
        user.setId(idCounter++);
        db.put(user.getId(),user);
        return user;
    }

    public Optional<User> findByUsername(String username){
        return db.values().stream()
                .filter(u->u.getUsername().equals(username))
                .findFirst();
    }

    public List<User> findAll(){
        return new ArrayList<>(db.values());
    }
}
