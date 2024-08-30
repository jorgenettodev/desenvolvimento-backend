package com.example.adotaPet.model;

import java.io.File;
import java.io.IOException;

public class Pet {

    private int id;
    private String especie;
    private String nome;
    private boolean jaFoiAdotado;

    public Pet() {

    }

    public Pet(int id, String especie, String nome, boolean jaFoiAdotado) {
        this.id = id;
        this.especie = especie;
        this.nome = nome;
        this.jaFoiAdotado = jaFoiAdotado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isJaFoiAdotado() {
        return jaFoiAdotado;
    }

    public void setJaFoiAdotado(boolean jaFoiAdotado) {
        this.jaFoiAdotado = jaFoiAdotado;
    }

}
