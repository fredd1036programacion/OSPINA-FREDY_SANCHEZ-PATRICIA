package com.proyectoIntegrador.dentalClinic.dto.salida.paciente;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


// si hay algun campo esta demas que se ingore.
@JsonIgnoreProperties(ignoreUnknown = true)
public class DomicilioSalidaDto {

    private int id;
    private String calle;
    private int numero;
    private String localidad;
    private String provincia;

    public DomicilioSalidaDto() {
    }

    public DomicilioSalidaDto(int id, String calle, int numero, String localidad, String provincia) {
        this.id = id;
        this.calle = calle;
        this.numero = numero;
        this.localidad = localidad;
        this.provincia = provincia;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }
}
