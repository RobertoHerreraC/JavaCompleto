package Proyectos.SistemaPedidos.app.repository;

import Proyectos.SistemaPedidos.app.model.Order;

import java.util.*;

public class OrderRepository {
    private Map<Long, Order> db = new HashMap<>();
    private Long idCounter = 1L;

    public Order save(Order order){
        order.setId(idCounter++);
        db.put(order.getId(),order);
        return order;
    }

    public Optional<Order> findById(Long id){
        return Optional.ofNullable(db.get(id));
    }

    public List<Order> findAll(){
        return new ArrayList<>(db.values());
    }
}
