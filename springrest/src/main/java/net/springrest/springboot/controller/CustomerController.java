package net.springrest.springboot.controller;

import lombok.AllArgsConstructor;

import net.springrest.springboot.model.Customer;
import net.springrest.springboot.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/Customers")
@AllArgsConstructor
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping
    public List<Customer> getallCustomer(){
        return customerService.findAllcustomers();
    }
    @PostMapping
    public Customer createCustomer(@RequestBody Customer Custom){
        return customerService.addCustomer(Custom);
    }
    @GetMapping("/{customerId}")
    public Customer getCustomer(@PathVariable String customerId)  {
        return customerService.getCustomerBycustomerId(customerId);
    }

    @GetMapping("/name/{name}")
    public List<Customer> findCustomerUsingName(@PathVariable String name) {
        return  customerService.getCustomerByName(name);
    }

    @GetMapping("/age/{age}")
    public List<Customer> findCustomerByAge(@PathVariable("age") String age){
        return customerService.getCustomerByAge(Integer.parseInt(age));
    }

    @GetMapping("/email/{email}")
    public List<Customer> findCustomerByEmail(@PathVariable String email){
        return customerService.getCustomerByEmail(email);
    }

    @PutMapping
    public Customer modifyCustomer(@RequestBody Customer Custom){
        return customerService.updateCustomer(Custom);
    }

    @DeleteMapping("/{customerId}")
    public String deleteCustomer(@PathVariable String customerId){
        return customerService.deleteCustomer(customerId);
    }



}
