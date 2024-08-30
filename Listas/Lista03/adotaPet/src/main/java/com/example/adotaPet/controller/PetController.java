package com.example.adotaPet.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.adotaPet.service.PetService;
import com.example.adotaPet.model.Pet;

import java.util.List;

@RestController
@RequestMapping("/pets")
public class PetController {
    final private PetService service = new PetService();

    @GetMapping
    public List<Pet> listarPets() throws Exception {
        return service.listarPets();
    }

    @PostMapping
    public String cadastrarNovoPet(@RequestBody Pet pet) throws Exception {
        return service.cadastrarNovoPet(pet);
    }
}
