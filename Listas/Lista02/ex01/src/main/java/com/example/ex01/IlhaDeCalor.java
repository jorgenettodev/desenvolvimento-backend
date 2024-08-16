package com.example.ex01;

public class IlhaDeCalor {
    private int id;
    private String bairro;
    private String zona;

    
    public IlhaDeCalor() {
    }


    public IlhaDeCalor(int id, String bairro, String zona) {
        this.id = id;
        this.bairro = bairro;
        this.zona = zona;
    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getBairro() {
        return bairro;
    }


    public void setBairro(String bairro) {
        this.bairro = bairro;
    }


    public String getZona() {
        return zona;
    }


    public void setZona(String zona) {
        this.zona = zona;
    }

    @Override
    public String toString() {
        return String.format(
            """
            Bairro: %s;
            Id: %s
            Zona: %s
            """, this.getId(), this.getBairro(), this.getZona());
    }   

}
