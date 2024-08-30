package com.example.adotaPet.repository;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.example.adotaPet.model.Pet;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PetRepository {
    private File arquivo = new File("src/main/resources/database/tb_pets.json");
    private ObjectMapper objectMapper = new ObjectMapper();

    private List<Pet> pets;

    public List<Pet> getAll() throws Exception {
        // verifica se o arquivo existe; senao existe: cria um novo arquivo;

        if (!arquivo.exists()) {
            arquivo.createNewFile();
        }

        // verifica se o arquivo ta vazio
        if (arquivo.length() > 0) {
            pets = objectMapper.readValue(arquivo, new TypeReference<ArrayList<Pet>>() {
            });
        } else {
            pets = new ArrayList<>();
        }

        return pets;
    }

    public boolean save(Pet pet) throws Exception {
        List<Pet> pets = getAll();

        // verifica se o pet já existe na lista
        for (Pet petNaLista : pets) {
            if (petNaLista.getId() == pet.getId()) {
                System.out.println("O pet id já existe na lista");
                return false;
            }
        }
        // se não existir na lista, adiciona na lista
        pets.add(pet);
        // atualiza o array com o novo pet.
        objectMapper.writeValue(arquivo, pets);

        // retorna true;
        return true;
    }

}
