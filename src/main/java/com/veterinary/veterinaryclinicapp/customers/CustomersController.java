package com.veterinary.veterinaryclinicapp.customers;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@NoArgsConstructor
@CrossOrigin(origins = "*")
public class CustomersController {

    @Autowired
    private CustomersService customersService;

    @RequestMapping("/customers")
    public List<Customers> getAllCustomers(){
        return customersService.getAllCustomers();
    }

    @RequestMapping("/customers/{id}")
    public Optional<Customers> getCustomers(@PathVariable Integer id){
        return customersService.getCustomers(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/customers")
    public void createCustomers(@RequestBody Customers customers){
        customersService.createCustomers(customers);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/customers/{id}")
    public void updateCustomers(@PathVariable Integer id, @RequestBody Customers customers){
        customersService.updateCustomers(id,customers);
    }

    @RequestMapping(method = RequestMethod.DELETE,value = "/customers/{id}")
    public void deleteCustomers(@PathVariable Integer id){
        customersService.deleteCustomers(id);
    }


}
