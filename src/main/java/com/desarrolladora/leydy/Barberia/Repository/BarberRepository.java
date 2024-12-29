package com.desarrolladora.leydy.Barberia.Repository;

import com.desarrolladora.leydy.Barberia.entity.Barber;
import com.desarrolladora.leydy.Barberia.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BarberRepository extends CrudRepository<Barber, Long> {
    Optional<Barber> findByEmail(String email);
}
