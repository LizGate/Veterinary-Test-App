package com.veterinary.veterinaryclinicapp.customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomersService {

    @Autowired
    private CustomersRepository customersRepository;

    public List<Customers> getAllCustomers(){
        List<Customers> customers = new ArrayList<>();
        customersRepository.findAll().forEach(customers::add);
        return customers;
    }

    public Optional<Customers> getCustomers(Integer id){
        return customersRepository.findById(id);
    }

    public void createCustomers(Customers customers){
        customersRepository.save(customers);
    }

    public void updateCustomers(Integer id, Customers customers){
        customersRepository.save(customers);
    }

    public void deleteCustomers(Integer id){
        customersRepository.deleteById(id);
    }


}
