package com.proyectoIntegrador.dentalClinic.dto.salida.paciente;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.proyectoIntegrador.dentalClinic.dto.entrada.paciente.DomicilioEntradaDto;

import javax.validation.constraints.*;
import java.time.LocalDate;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PacienteSalidaDto {


    private String id;

    private String nombre;

    private String apellido;

    // NO SE SUELE MUESTRAT EL DNI POR SER UN DATO SENSIBLE
    private int dni;

    private LocalDate fechaIngreso;


    private DomicilioEntradaDto domicilio;

    public PacienteSalidaDto() {
    }

    public PacienteSalidaDto(String id, String nombre, String apellido, int dni, LocalDate fechaIngreso, DomicilioEntradaDto domicilio) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechaIngreso = fechaIngreso;
        this.domicilio = domicilio;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public DomicilioEntradaDto getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(DomicilioEntradaDto domicilio) {
        this.domicilio = domicilio;
    }
}
