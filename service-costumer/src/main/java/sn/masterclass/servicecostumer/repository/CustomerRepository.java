package sn.masterclass.servicecostumer.repository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.data.jpa.repository.JpaRepository;
import sn.masterclass.servicecostumer.entities.Customer;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository <Customer, Long> {
    List<Customer> findByEmail(String email);

    List<Customer> findByFirstnameContainingIgnoreCase(String keyword);

}
