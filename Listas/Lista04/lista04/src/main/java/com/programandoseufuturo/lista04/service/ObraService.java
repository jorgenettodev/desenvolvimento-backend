package com.programandoseufuturo.lista04.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

import com.programandoseufuturo.lista04.model.Obra;

import com.programandoseufuturo.lista04.repository.ObraRepository;

@Component
public class ObraService {
    ObraRepository repository;

    @Autowired
    public ObraService(ObraRepository repository) {
        this.repository = repository;
    }

    public List<Obra> listarObras() throws IOException {
        return repository.getAll();
    }

    public Obra cadastrarNovaObra(Obra novaObra) throws IOException {
        if (repository.save(novaObra)) {
            return novaObra;
        }
        return null;
    }

    public Obra atualizarObra(Obra obra) throws IOException {
        if (repository.update(obra)) {
            return obra;
        }
        return null;
    }
}
