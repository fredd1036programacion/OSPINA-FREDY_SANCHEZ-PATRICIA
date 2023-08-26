package com.proyectoIntegrador.dentalClinic.service.impl;

import com.proyectoIntegrador.dentalClinic.dao.IDao;
import com.proyectoIntegrador.dentalClinic.entity.Paciente;
import com.proyectoIntegrador.dentalClinic.service.IPacienteService;
import org.springframework.stereotype.Service;

import java.util.List;

// been de tipo service
@Service

public class PacienteService implements IPacienteService {

    //atributo Idao
    private IDao<Paciente> pacienteIDao;


    // constructor
    public PacienteService(IDao<Paciente> pacienteIDao) {
        this.pacienteIDao = pacienteIDao;
    }


    //metodos

    @Override
    public Paciente registrarPaciente(Paciente paciente){
        return pacienteIDao.registrar(paciente);
    }

    @Override
    public Paciente buscarPacientePorId(int id){
        return pacienteIDao.buscarPorId(id);
    }

    @Override
    public List<Paciente> listarPacientes(){
        return pacienteIDao.listarTodos();
    }

    @Override
    public void eliminarPaciente(int id){
        pacienteIDao.eliminar(id);
    }

    @Override
    public Paciente modificarPaciente(Paciente modificarPaciente) {
        return pacienteIDao.modificar(modificarPaciente);
    }
}
