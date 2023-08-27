package com.proyectoIntegrador.dentalClinic.service.impl;

import com.proyectoIntegrador.dentalClinic.dao.IDao;
import com.proyectoIntegrador.dentalClinic.entity.Odontologo;
import com.proyectoIntegrador.dentalClinic.service.IOdontologoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class OdontologoService implements IOdontologoService {
    private IDao<Odontologo> odontologoIDao;

    public OdontologoService(IDao<Odontologo> odontologoIDao) {
        this.odontologoIDao = odontologoIDao;
    }

    public Odontologo guardarOdontologo(Odontologo odontologo) {
        return odontologoIDao.registrar(odontologo);
    }

    public Odontologo buscarOdontologoPorId(int id) {
        return odontologoIDao.buscarPorId(id);
    }

    public List<Odontologo> listarOdontologos() {
        return odontologoIDao.listarTodos();
    }

    public void eliminarOdontologo(int id) {
        odontologoIDao.eliminar(id);
    }

    @Override
    public Odontologo modificarOdontologo(Odontologo modificarOdontologo) {
        return odontologoIDao.modificar(modificarOdontologo);
    }


}
