package com.backend.integrador.entity;

public class Odontologo {

    private int id;
    private int numeroMatricula;
    private String nombre;
    private String apellido;

    public Odontologo(int id, int numeroMatricula, String nombre, String apellido) {
        this.id = id;
        this.numeroMatricula = numeroMatricula;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Odontologo(int numeroMatricula, String nombre, String apellido) {
        this.numeroMatricula = numeroMatricula;
        this.nombre = nombre;
        this.apellido = apellido;
    }
    
}
