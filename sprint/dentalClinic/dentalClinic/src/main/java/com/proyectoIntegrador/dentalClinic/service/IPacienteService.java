package com.proyectoIntegrador.dentalClinic.service;

import com.proyectoIntegrador.dentalClinic.dao.IDao;
import com.proyectoIntegrador.dentalClinic.entity.Paciente;

import java.util.List;

public interface IPacienteService {
    //metodos


    Paciente registrarPaciente(Paciente paciente);

    Paciente buscarPacientePorId(int id);

    List<Paciente> listarPacientes();

    void eliminarPaciente(int id);

    // la clase paciente del inicio es el retorno, se espera que retorne un paciente
    Paciente modificarPaciente(Paciente modificarPaciente);

}
