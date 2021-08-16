package com.veterinary.veterinaryclinicapp.pets;

import com.veterinary.veterinaryclinicapp.customers.Customers;
import com.veterinary.veterinaryclinicapp.customers.CustomersService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@NoArgsConstructor
@CrossOrigin(origins = "*")
public class PetsController {

    @Autowired
    private PetsService petsService;

    @RequestMapping("/pets")
    public List<Pets> getAllPets(){
        return petsService.getAllPets();
    }

    @RequestMapping("/pets/{id}")
    public Optional<Pets> getPets(@PathVariable Integer id){
        return petsService.getPets(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/pets")
    public void createPets(@RequestBody Pets pets){
        petsService.createPets(pets);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/pets/{id}")
    public void updatePets(@PathVariable Integer id, @RequestBody Pets pets){
        petsService.updatePets(id,pets);
    }

    @RequestMapping(method = RequestMethod.DELETE,value = "/pets/{id}")
    public void deletePets(@PathVariable Integer id){
        petsService.deletePets(id);
    }


}
