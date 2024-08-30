package com.example.adotaPet.service;

import com.example.adotaPet.model.Pet;
import com.example.adotaPet.repository.PetRepository;
import java.util.*;

public class PetService {
    private final PetRepository repository = new PetRepository();

    public String cadastrarNovoPet(Pet pet) throws Exception {
        if (repository.save(pet)) {
            return String.format("%s adicionado com sucesso!", pet.getNome());
        }

        return String.format("Erro: Id deve ser unico. O id: %s já existe na lista", pet.getId());

    }

    public List<Pet> listarPets() throws Exception {
        return repository.getAll();
    }

}
