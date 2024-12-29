package com.desarrolladora.leydy.Barberia.Repository;

import com.desarrolladora.leydy.Barberia.entity.Shopping;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingRepository extends CrudRepository<Shopping,Long> {
}
