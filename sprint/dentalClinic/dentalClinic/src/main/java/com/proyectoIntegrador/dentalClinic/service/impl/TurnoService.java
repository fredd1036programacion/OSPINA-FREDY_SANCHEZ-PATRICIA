package com.proyectoIntegrador.dentalClinic.service.impl;

;
import com.proyectoIntegrador.dentalClinic.dto.entrada.modificacion.TurnoModificacionEntradaDto;
import com.proyectoIntegrador.dentalClinic.dto.entrada.turno.TurnoEntradaDto;
import com.proyectoIntegrador.dentalClinic.dto.salida.odontologo.OdontologoSalidaDto;
import com.proyectoIntegrador.dentalClinic.dto.salida.paciente.PacienteSalidaDto;
import com.proyectoIntegrador.dentalClinic.dto.salida.turno.TurnoSalidaDto;
import com.proyectoIntegrador.dentalClinic.entity.Odontologo;
import com.proyectoIntegrador.dentalClinic.entity.Paciente;
import com.proyectoIntegrador.dentalClinic.entity.Turno;
import com.proyectoIntegrador.dentalClinic.repository.TurnoRepository;
import com.proyectoIntegrador.dentalClinic.service.ITurnoService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurnoService implements ITurnoService {
    private final Logger LOGGER = LoggerFactory.getLogger(TurnoService.class);

    //que necesitamos en el servicio para funcionar

    private final TurnoRepository turnoRepository;
    private final ModelMapper modelMapper;

    //necesitmos los odontologos y los pacientes

    private final OdontologoService odontologoService;

    private final PacienteService pacienteService;

    public TurnoService(TurnoRepository turnoRepository, ModelMapper modelMapper, OdontologoService odontologoService, PacienteService pacienteService) {
        this.turnoRepository = turnoRepository;
        this.modelMapper = modelMapper;
        this.odontologoService = odontologoService;
        this.pacienteService = pacienteService;
    }

    @Override
    public TurnoSalidaDto registrarTurno(TurnoEntradaDto turnoEntradaDto) {
        TurnoSalidaDto turnoSalidaDto;

        PacienteSalidaDto paciente = pacienteService.buscarPacientePorId(turnoEntradaDto.getPacienteId());
        OdontologoSalidaDto odontologo = odontologoService.buscarOdontologoPorId(turnoEntradaDto.getOdontologoId());

        String pacienteNoEnBdd = "El paciente no se encuentra en nuestra base de datos";
        String odontologoNoEnBdd = "El odontologo no se encuentra en nuestra base de datos";

        if(paciente == null || odontologo == null){
            if(paciente == null && odontologo == null){
                LOGGER.error("El paciente y el odontologo no se encuentran en nuestra base de datos");
                throw new RuntimeException("El paciente y el odontologo no se encuentran en nuestra base de datos");
            } else if (paciente == null) {
                LOGGER.error(pacienteNoEnBdd);
                throw new RuntimeException(pacienteNoEnBdd);
            } else {
                LOGGER.error(odontologoNoEnBdd);
                throw new RuntimeException(odontologoNoEnBdd);
            }
        } else {
            Turno turnoNuevo = turnoRepository.save(modelMapper.map(turnoEntradaDto, Turno.class));
            turnoSalidaDto = entidadADto(turnoNuevo);
            LOGGER.info("Nuevo turno registrado con exito: {}", turnoSalidaDto);
        }

        return turnoSalidaDto;
    }

    @Override
    public List<TurnoSalidaDto> listarTurno() {

        List<TurnoSalidaDto> turnos = turnoRepository.findAll().stream()
                .map(this::entidadADto).toList();

        LOGGER.info("Listado de todos los turnos: {}", turnos);

        return turnos;
   }

    @Override
    public TurnoSalidaDto buscarTurnoPorId(Long id) {

        Turno turnoBuscado = turnoRepository.findById(id).orElse(null);

        TurnoSalidaDto turnoSalidaDto = null;
        if (turnoBuscado != null) {
            turnoSalidaDto = entidadADto(turnoBuscado);
            LOGGER.info("Turno encontrado: {}", turnoSalidaDto);
        } else LOGGER.error("El id no se encuentra registrado en la base de datos");

        return turnoSalidaDto;
        }

    @Override
    public void eliminarTurno(Long id) {
        if (buscarTurnoPorId(id) != null) {
            turnoRepository.deleteById(id);
            LOGGER.warn("Se ha eliminado el turno con id: {}", id);
        } else {
            LOGGER.error("No se ha encontrado el turno con id {}", id);

        }


    }

    @Override
    public TurnoSalidaDto modificarTurno(TurnoModificacionEntradaDto turnoModificado) {
        Turno turnoAActualizar = turnoRepository.findById(turnoModificado.getId()).orElse(null);
        TurnoSalidaDto turnoSalidaDto = null;

        if (turnoAActualizar != null) {

            turnoAActualizar.setPaciente(modelMapper.map(pacienteService.buscarPacientePorId(turnoModificado.getPacienteId()), Paciente.class));
            turnoAActualizar.setOdontologo(modelMapper.map(odontologoService.buscarOdontologoPorId(turnoModificado.getOdontologoId()), Odontologo.class));
            turnoAActualizar.setFechaYHora(turnoModificado.getFechaYHora());
            turnoRepository.save(turnoAActualizar);

            turnoSalidaDto = entidadADto(turnoAActualizar);

            LOGGER.warn("Turno actualizado: {}", turnoSalidaDto);

        } else {
            LOGGER.error("No fue posible actualizar los datos ya que el turno no se encuentra registrado");

        }


        return turnoSalidaDto;
    }


    private void configureMappings() {
        modelMapper.typeMap(Turno.class, TurnoSalidaDto.class)
                .addMappings(mapper -> mapper.map(Turno::getPaciente, TurnoSalidaDto::setPacienteTurnoSalidaDto))
                .addMappings(mapper -> mapper.map(Turno::getOdontologo, TurnoSalidaDto::setOdontologoTurnoSalidaDto));
    }

    public TurnoSalidaDto entidadADto(Turno turno) {
        return modelMapper.map(turno, TurnoSalidaDto.class);
    }

    public TurnoSalidaDto turnoADtoSalida(Turno turno){

        return modelMapper.map(turno, TurnoSalidaDto.class);
    }

    public Turno dtoModificadoAturno (TurnoModificacionEntradaDto turnoEntradaDto){
        return modelMapper.map(turnoEntradaDto, Turno.class);

    }
}
