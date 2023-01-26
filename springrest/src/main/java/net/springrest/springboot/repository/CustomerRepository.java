package net.springrest.springboot.repository;

import net.springrest.springboot.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CustomerRepository extends MongoRepository<Customer,String > {
    List<Customer> findByName(String Name);
    List<Customer> findByEmail(String Email);
    List<Customer> findByAge(int Age);
}

