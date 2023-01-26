package net.springrest.springboot.service;


import net.springrest.springboot.model.Customer;
import net.springrest.springboot.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class CustomerService {
    @Autowired
    private CustomerRepository repository;

    //CRUD
     public Customer addCustomer(Customer custom){
        custom.setCustomerId(UUID.randomUUID().toString().split("-")[0]);
        return repository.save(custom);
    }

    public List<Customer> findAllcustomers(){
         return repository.findAll();
    }

    public Customer getCustomerBycustomerId(String customerId)  {
         return repository.findById(customerId).get();
    }

    public List<Customer> getCustomerByName(String name)  {
         return repository.findByName(name);
    }

    public List<Customer> getCustomerByAge(int age){
         return repository.findByAge(age);
    }

    public List<Customer> getCustomerByEmail(String emailId){
         return repository.findByEmail(emailId);
    }

    public Customer updateCustomer (Customer customerRequest){
         return repository.save(customerRequest);
    }

    public String deleteCustomer(String customerId){
        repository.deleteById(customerId);
        return customerId+ "customer details deleted";
    }

}
