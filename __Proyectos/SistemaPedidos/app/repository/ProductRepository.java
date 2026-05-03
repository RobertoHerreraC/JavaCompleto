package __Proyectos.SistemaPedidos.app.repository;

import __Proyectos.SistemaPedidos.app.model.Product;

import java.util.*;

public class ProductRepository {
    private Map<Long, Product> db = new HashMap<>();
    private Long idCounter = 1L;

    public Product save(Product product){
        product.setId(idCounter++);
        db.put(product.getId(),product);
        return product;
    }

    public Optional<Product> findById(Long id){
        return Optional.ofNullable(db.get(id));
    }

    public List<Product> findAll(){
        return new ArrayList<>(db.values());
    }
}
