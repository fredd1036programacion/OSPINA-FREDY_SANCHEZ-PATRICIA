package com.proyectoIntegrador.dentalClinic.service.impl;

import com.proyectoIntegrador.dentalClinic.dao.IDao;
import com.proyectoIntegrador.dentalClinic.dto.entrada.paciente.PacienteEntradaDto;
import com.proyectoIntegrador.dentalClinic.dto.salida.paciente.PacienteSalidaDto;
import com.proyectoIntegrador.dentalClinic.entity.Paciente;
import com.proyectoIntegrador.dentalClinic.service.IPacienteService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

// been de tipo service
@Service

public class PacienteService implements IPacienteService {

    //atributo Idao
    private IDao<Paciente> pacienteIDao;
    private final ModelMapper modelMapper;


    // constructor
    public PacienteService(IDao<Paciente> pacienteIDao, ModelMapper modelMapper) {
        this.pacienteIDao = pacienteIDao;
        this.modelMapper = modelMapper;
        configureMapping();
    }


    //metodos

    @Override
    public PacienteSalidaDto registrarPaciente(PacienteEntradaDto paciente) {
        //dto de entrara a entidad para enviar al Idao
        Paciente pacienteRegistrado = pacienteIDao.registrar(mapToEntity(paciente));


        return pacienteIDao.registrar(paciente);
    }

    @Override
    public Paciente buscarPacientePorId(int id) {
        return pacienteIDao.buscarPorId(id);
    }

    @Override
    public List<Paciente> listarPacientes() {
        return pacienteIDao.listarTodos();
    }

    @Override
    public void eliminarPaciente(int id) {
        pacienteIDao.eliminar(id);
    }

    @Override
    public Paciente modificarPaciente(Paciente modificarPaciente) {
        return pacienteIDao.modificar(modificarPaciente);
    }

    // MODELMAPPER PARA PASAR LA INFO DE EL DTO A PACIENTE PARA QUE LO RECIBA EL Idao QUE ESTA ESTRUCTURADO CON LA ENTIDAD

    // privado por que solo se va a usar aqui, configuracion del modelmapper
    private void configureMapping() {
        modelMapper.typeMap(PacienteSalidaDto.class, Paciente.class)
                .addMappings(mapper -> mapper.map(PacienteSalidaDto::getDomicilio, Paciente::setDomicilio));
    }

    public Paciente mapToEntity(PacienteEntradaDto pacienteEntradaDto){
        return modelMapper.map(pacienteEntradaDto, Paciente.class);
    }
}