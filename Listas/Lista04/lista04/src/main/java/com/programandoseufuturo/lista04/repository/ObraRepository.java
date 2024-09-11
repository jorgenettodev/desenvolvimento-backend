package com.programandoseufuturo.lista04.repository;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.programandoseufuturo.lista04.model.Obra;

@Component
public class ObraRepository {
    private File arquivo = new File("src/main/resources/database/tb_obras.json");
    private ObjectMapper objectMapper = new ObjectMapper();
    private final int ZERO_BYTES = 0;

    public List<Obra> getAll() throws IOException {
        if (!arquivo.exists()) {
            arquivo.createNewFile();
        }

        if (arquivo.length() > ZERO_BYTES) {
            List<Obra> obras = objectMapper.readValue(arquivo, new TypeReference<List<Obra>>() {
            });
            return obras;
        }

        return new ArrayList<>();
    }

    public boolean save(Obra obra) throws IOException {
        List<Obra> obras = this.getAll();

        for (Obra obraNoDatabase : obras) {
            if (obraNoDatabase.getId() == obra.getId()) {
                return false;
            }
        }

        obras.add(obra);
        objectMapper.writeValue(arquivo, obras);
        return true;
    }

    public boolean update(Obra obraAtualizada) throws IOException {
        List<Obra> obras = this.getAll();

        for (Obra obraNaLista : obras) {
            if (obraNaLista.getId() == obraAtualizada.getId()) {
                obraNaLista.setNome(obraAtualizada.getNome());
                obraNaLista.setAutor(obraAtualizada.getAutor());
                obraNaLista.setPreco(obraAtualizada.getPreco());
                obraNaLista.setJaFoiVendida(obraAtualizada.isJaFoiVendida());

                objectMapper.writeValue(arquivo, obras);
                return true;
            }
        }
        return false;
    }
}
