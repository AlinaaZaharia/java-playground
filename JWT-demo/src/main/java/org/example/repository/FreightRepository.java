package org.example.repository;

import org.example.entity.Freight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface FreightRepository extends JpaRepository<Freight, Long> {
    List<Freight> findByCustomerId(long customerId);
    Boolean existsByCustomerId(long customerId);
}