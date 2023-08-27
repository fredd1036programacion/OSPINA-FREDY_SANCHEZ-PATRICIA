package com.proyectoIntegrador.dentalClinic.service;

import com.proyectoIntegrador.dentalClinic.dao.IDao;
import com.proyectoIntegrador.dentalClinic.entity.Odontologo;
import com.proyectoIntegrador.dentalClinic.entity.Paciente;

import java.util.List;

public interface IOdontologoService {


     Odontologo guardarOdontologo(Odontologo odontologo);

     Odontologo buscarOdontologoPorId(int id);

     List<Odontologo> listarOdontologos();

     void eliminarOdontologo(int id);

     Odontologo modificarOdontologo (Odontologo modificarOdontologo);

}
