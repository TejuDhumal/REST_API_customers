package net.springrest.springboot.repository;

import net.springrest.springboot.model.customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface Customer_Repository extends MongoRepository<customer,String > {
    List<customer> findByName(String name);

    List<customer> findByEmail(String email);

    List<customer> findByAge(int age);
}
