package com.example.examensemana10.entities;

public class Pokemon {
    public int numero;
    public String nombre;
    public String tipo;
    public String region;

    public Pokemon() {
    }

    public Pokemon(String nombre, String tipo, String region) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.region = region;
    }

    public Pokemon(int numero, String nombre, String tipo, String region) {
        this.numero = numero;
        this.nombre = nombre;
        this.tipo = tipo;
        this.region = region;
    }
}
