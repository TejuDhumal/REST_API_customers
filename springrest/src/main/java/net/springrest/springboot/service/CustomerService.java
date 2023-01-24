package net.springrest.springboot.service;

import net.springrest.springboot.model.customer;
import net.springrest.springboot.repository.Customer_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service

public class CustomerService {
    @Autowired
    private Customer_Repository repository;

    //CRUD

    public customer addcustomer(customer cust){
        cust.setCustomerId(UUID.randomUUID().toString().split("-")[0]);
        return repository.save(cust);
    }
    public List<customer> findAllcustomers(){
        return repository.findAll();
    }
    public customer getCustomerBycustomerId(String customerId){
        return repository.findById(customerId).get();
    }

    public List<customer> getCustomerByName(String name){
        return repository.findByName(name);
    }
    public List<customer> getCustomerByAge(int age){
        return repository.findByAge(age);
    }
    public List<customer> getCustomerByEmail(String emailid){
        return repository.findByEmail(emailid);
    }
    public customer updatecustomer(customer customerRequest){
      customer existingCustomer=  repository.findById(customerRequest.getCustomerId()).get();
      existingCustomer.setDescription(customerRequest.getDescription());
      existingCustomer.setAge(customerRequest.getAge());
      existingCustomer.setName(customerRequest.getName());
      existingCustomer.setEmail(customerRequest.getEmail());
      return repository.save(existingCustomer);

    }
    public String deleteCustomer(String customerId){
        repository.deleteById(customerId);
        return customerId+ "customer deleted";
    }

}
