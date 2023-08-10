package com.backend.integrador.dao.imp;

import com.backend.integrador.dao.H2Connection;
import com.backend.integrador.dao.IDao;
import com.backend.integrador.entity.Odontologo;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OdontologoDaoH2  implements IDao<Odontologo> {
    private final Logger LOGGER = Logger.getLogger(OdontologoDaoH2.class);

    @Override
    public Odontologo registrar(Odontologo odontologo) {
       Connection connection = null;
       Odontologo odontologo1 = null;
       try{

           connection = H2Connection.getConnection();
           connection.setAutoCommit(false);
           PreparedStatement ps = connection.prepareStatement("INSERT INTO ODONTOLOGOS (NUMEROMATRICULA, NOMBRE, APELLIDO) VALUES (?,?,?)", Statement.RETURN_GENERATED_KEYS);

           ps.setInt(1, odontologo.getNumeroMatricula());
           ps.setString(2, odontologo.getNombre());
           ps.setString(3, odontologo.getApellido());
           ps.execute();

           ResultSet key = ps.getGeneratedKeys();

           odontologo1 = new Odontologo(odontologo.getNumeroMatricula(),odontologo.getNombre(),odontologo.getApellido());
           while (key.next()) {
               odontologo1.setId(key.getInt(1));
           }

           connection.commit();

           LOGGER.info("Odontologo registrado: " + odontologo1);

       }catch (Exception e) {
               LOGGER.error(e.getMessage());
               e.printStackTrace();
               if (connection != null) {
                   try {
                       connection.rollback();
                       System.out.println("Tuvimos un problema");
                       e.printStackTrace();
                   } catch (SQLException exception) {
                       LOGGER.error(exception.getMessage());
                       exception.printStackTrace();
                   }
               }
        } finally {
           try {
               connection.close();
           } catch (Exception ex) {
               LOGGER.error("No se pudo cerrar la conexion: " + ex.getMessage());
               ex.printStackTrace();
           }
       }


        return odontologo1;
    }

    @Override
    public Odontologo buscarPorId(int id) {
        Connection connection = null;
        Odontologo odontologo = null;

        try{

            connection = H2Connection.getConnection();
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM ODONTOLOGOS WHERE ID = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                odontologo = new Odontologo(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4));
            }

            if (odontologo == null) LOGGER.error("No se ha encontrado el odontologo con ID: " + id);
            else LOGGER.info("se ha encontrado el odontologo con ID: " + odontologo);

        }catch (Exception e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception ex) {
                LOGGER.error("Ha ocurrido un error al intentar cerrar la bdd. " + ex.getMessage());
                ex.printStackTrace();
            }
        }


        return odontologo;
    }

    @Override
    public List<Odontologo> listarTodos() {
        Connection connection = null;
        List <Odontologo> odontologos = new ArrayList<>();

        try{
            connection = H2Connection.getConnection();
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM ODONTOLOGOS");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Odontologo odontologo = new Odontologo(rs.getInt(1),rs.getInt(2),rs.getString(3), rs.getString(4));
                odontologos.add(odontologo);
            }

            LOGGER.info("Los odontologos se encuentran listados: " + odontologos);


        }catch (Exception e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception ex) {
                LOGGER.error("Ha ocurrido un error al intentar cerrar la bdd. " + ex.getMessage());
                ex.printStackTrace();
            }
        }

        return null;
    }
}
