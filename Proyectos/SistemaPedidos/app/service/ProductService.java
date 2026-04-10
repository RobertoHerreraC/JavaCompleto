package Proyectos.SistemaPedidos.app.service;

import Proyectos.SistemaPedidos.app.dto.ProductDTO;
import Proyectos.SistemaPedidos.app.model.Product;
import Proyectos.SistemaPedidos.app.repository.ProductRepository;

public class ProductService {
    private ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public Product save(ProductDTO dto){
        if(dto.price<=0) throw new RuntimeException("Precio invalido");

        Product product = new Product(null, dto.name, dto.price);
        return repository.save(product);

    }

    public Product findById(Long id){
        return repository.findById(id)
                .orElseThrow(()-> new RuntimeException("Producto no existe"));
    }
}
