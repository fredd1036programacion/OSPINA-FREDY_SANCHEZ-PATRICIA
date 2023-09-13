package com.proyectoIntegrador.dentalClinic.service;

import com.proyectoIntegrador.dentalClinic.dto.entrada.modificacion.PacienteModificacionEntradaDto;
import com.proyectoIntegrador.dentalClinic.dto.entrada.modificacion.TurnoModificacionEntradaDto;
import com.proyectoIntegrador.dentalClinic.dto.entrada.turno.TurnoEntradaDto;
import com.proyectoIntegrador.dentalClinic.dto.salida.paciente.PacienteSalidaDto;
import com.proyectoIntegrador.dentalClinic.dto.salida.turno.TurnoSalidaDto;

import java.util.List;

public interface ITurnoService {
    TurnoSalidaDto registrarTurno(TurnoEntradaDto turnoEntradaDto);

    List<TurnoSalidaDto> listarTurno();
    TurnoSalidaDto buscarTurnoPorId(Long id);
    void eliminarTurno(Long id);

    //Terminar la modificacion solicitada por la profe

    TurnoSalidaDto modificarTurno(TurnoModificacionEntradaDto turnoModificado);
}
