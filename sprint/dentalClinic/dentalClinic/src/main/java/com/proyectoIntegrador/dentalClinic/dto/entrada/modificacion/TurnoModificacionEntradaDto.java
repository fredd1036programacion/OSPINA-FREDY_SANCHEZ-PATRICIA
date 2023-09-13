package com.proyectoIntegrador.dentalClinic.dto.entrada.modificacion;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.proyectoIntegrador.dentalClinic.entity.Odontologo;
import com.proyectoIntegrador.dentalClinic.entity.Paciente;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class TurnoModificacionEntradaDto {

    @NotNull
    private Long id;
    @NotNull
    private Long odontologoId;
    @NotNull
    private Long pacienteId;
    //se va a usar LocakDateTime para que se pueda regitrar la fecha y la hora tambien
    @NotNull
    private LocalDateTime fechaYHora;

    public TurnoModificacionEntradaDto() {
    }

    public TurnoModificacionEntradaDto(Long id, Long odontologoId, Long pacienteId, LocalDateTime fechaYHora) {
        this.id = id;
        this.odontologoId = odontologoId;
        this.pacienteId = pacienteId;
        this.fechaYHora = fechaYHora;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOdontologoId() {
        return odontologoId;
    }

    public void setOdontologoId(Long odontologoId) {
        this.odontologoId = odontologoId;
    }

    public Long getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(Long pacienteId) {
        this.pacienteId = pacienteId;
    }

    public LocalDateTime getFechaYHora() {
        return fechaYHora;
    }

    public void setFechaYHora(LocalDateTime fechaYHora) {
        this.fechaYHora = fechaYHora;
    }
}
