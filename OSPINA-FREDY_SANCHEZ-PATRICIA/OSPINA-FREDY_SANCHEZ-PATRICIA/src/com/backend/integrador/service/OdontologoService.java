package com.backend.integrador.service;

import com.backend.integrador.entity.Odontologo;
import com.backend.integrador.dao.IDao;

import java.util.List;

public class OdontologoService {

    private IDao<Odontologo> odontologoIDao;

    public OdontologoService(IDao<Odontologo> odontologoIDao) {
        this.odontologoIDao = odontologoIDao;
    }

    public Odontologo registrarOdontologo(Odontologo odontologo){
        return odontologoIDao.registrar(odontologo);
    }

    public Odontologo buscarOdontologoPorId (int id){
        return odontologoIDao.buscarPorId(id);
    }

    public List<Odontologo> listarTodosLosOdontologos(){
        return odontologoIDao.listarTodos();
    }
}
