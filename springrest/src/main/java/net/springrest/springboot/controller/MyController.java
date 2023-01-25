package net.springrest.springboot.controller;

import lombok.AllArgsConstructor;

import net.springrest.springboot.model.customer;
import net.springrest.springboot.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
@AllArgsConstructor
public class MyController {
    @Autowired

    private CustomerService service;
    @PostMapping

    public customer createCustomer(@RequestBody customer custom){
        return service.addcustomer(custom);
    }
    @GetMapping
    public List<customer> getAllCustomers(){
        return service.findAllcustomers();

    }
    @GetMapping("/{customerId}")
    public customer getCustomer(@PathVariable String customerId)  {
        return service.getCustomerBycustomerId(customerId);

    }
    @GetMapping("/name/{name}")
    public List<customer> findCustomerUsingName(@PathVariable String name) {
        return  service.getCustomerByName(name);
    }

    @GetMapping("/age/{age}")

    public List<customer> findCustomerByAge(@PathVariable("age") String age){
        return service.getCustomerByAge(Integer.parseInt(age));
    }
    @GetMapping("/email/{email}")
public List<customer> findCustomerByEmail(@PathVariable String email){
        return service.getCustomerByEmail(email);
}
    @PutMapping
    public customer modifyCustomer(@RequestBody customer custom){
        return service.updatecustomer(custom);

    }
    @DeleteMapping("/{customerId}")
    public String deleteCustomer(@PathVariable String customerId){
        return service.deleteCustomer(customerId);
    }



}
