package com.veterinary.veterinaryclinicapp.pets;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PetsService {

    @Autowired
    private PetsRepository petsRepository;

    public List<Pets> getAllPets(){
        List<Pets> pets = new ArrayList<>();
        petsRepository.findAll().forEach(pets::add);
        return pets;
    }

    public Optional<Pets> getPets(Integer id){
        return petsRepository.findById(id);
    }

    public void createPets(Pets pets){
        petsRepository.save(pets);
    }

    public void updatePets(Integer id, Pets pets){
        petsRepository.save(pets);
    }

    public void deletePets(Integer id){
        petsRepository.deleteById(id);
    }

}
