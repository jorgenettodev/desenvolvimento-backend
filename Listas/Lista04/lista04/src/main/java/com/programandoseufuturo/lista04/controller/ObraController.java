package com.programandoseufuturo.lista04.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.programandoseufuturo.lista04.service.ObraService;
import com.programandoseufuturo.lista04.model.Obra;

import java.io.IOException;
import java.util.List;

@Component
@RestController
@RequestMapping("/obras")
public class ObraController {
    ObraService service;

    @Autowired
    public ObraController(ObraService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Obra>> listarObras() throws IOException {

        return ResponseEntity
                .status(HttpStatus.OK.value())
                .body(service.listarObras());

    }

    @PostMapping
    public ResponseEntity<Obra> cadastrarNovaObra(@RequestBody Obra obra) throws IOException {
        if (service.cadastrarNovaObra(obra) == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

        }
        return ResponseEntity.status(HttpStatus.CREATED).body(service.cadastrarNovaObra(obra));
    }

    @PutMapping
    public ResponseEntity<Obra> atualizarObra(@RequestBody Obra obra) throws IOException {
        if (service.atualizarObra(obra) == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.OK.value()).body(service.cadastrarNovaObra(obra));
    }
}
