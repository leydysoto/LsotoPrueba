package com.desarrolladora.leydy.Barberia.Repository;

import com.desarrolladora.leydy.Barberia.entity.Category;
import com.desarrolladora.leydy.Barberia.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
    List<Product> findByDiscount(Integer discount);
    List<Product>findByCategory(Category Category);

}
