package com.codetests.bnta.petAPI.controllers;

import com.codetests.bnta.petAPI.models.Pet;
import com.codetests.bnta.petAPI.repositories.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PetController {

    @Autowired
    private PetRepository petRepository;

    @GetMapping(value = "/pets")
    public ResponseEntity<List<Pet>> getAllPets(){
        List<Pet> pets = petRepository.findAll();
        return new ResponseEntity<>(pets, HttpStatus.OK);
    }

    @PostMapping(value = "/pets")
    public ResponseEntity<Pet> addNewPet(@RequestBody Pet pet){
        Pet savedPet = petRepository.save(pet);
        return new ResponseEntity<>(savedPet, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/deletealltherecords")
    public ResponseEntity<String> deleteAllRecords(){
        petRepository.deleteAll();
        return new ResponseEntity("All entries deleted", HttpStatus.NO_CONTENT);
    }

}
