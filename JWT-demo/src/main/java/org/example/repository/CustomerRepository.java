package org.example.repository;

import org.example.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findByCustomerEmail(String customerEmail);
    Page<Customer> findAll(Pageable pageable);
    Boolean existsByCustomerEmail(String customerEmail);
}