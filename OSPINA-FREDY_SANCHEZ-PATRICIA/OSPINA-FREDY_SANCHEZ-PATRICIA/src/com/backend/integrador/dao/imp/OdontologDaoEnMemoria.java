package com.backend.integrador.dao.imp;

import com.backend.integrador.dao.IDao;
import com.backend.integrador.entity.Odontologo;
import org.apache.log4j.Logger;

import java.util.List;

public class OdontologDaoEnMemoria implements IDao<Odontologo> {

    private static final Logger LOGGER = Logger.getLogger(OdontologDaoEnMemoria.class);
    private List<Odontologo> odontologoslista;

    public OdontologDaoEnMemoria(List<Odontologo> odontologoslista) {
        this.odontologoslista = odontologoslista;
    }

    @Override
    public Odontologo registrar(Odontologo odontologo) {
        odontologoslista.add(odontologo);
        LOGGER.info("Odontologo guardado: " + odontologo);
        return odontologo;
    }

    @Override
    public Odontologo buscarPorId(int id) {
        Odontologo odontologoBuscado = odontologoslista.get(id -1);
        if(odontologoBuscado != null) LOGGER.info("El Odontologo de ID " +id + "se encuentra en la Base de Datos " + odontologoBuscado);
        return odontologoBuscado;
    }

    @Override
    public List<Odontologo> listarTodos() {
        LOGGER.info("Lista de todos los odontologos : /n" + odontologoslista);
        return odontologoslista;
    }
}
