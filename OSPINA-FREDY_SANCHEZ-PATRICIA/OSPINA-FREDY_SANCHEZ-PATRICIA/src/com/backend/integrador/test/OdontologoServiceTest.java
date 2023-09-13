package com.backend.integrador.test;

import com.backend.integrador.dao.imp.OdontologDaoEnMemoria;
import com.backend.integrador.dao.imp.OdontologoDaoH2;
import com.backend.integrador.entity.Odontologo;
import com.backend.integrador.service.OdontologoService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;



import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import static org.junit.jupiter.api.Assertions.*;

public class OdontologoServiceTest {
    private static Connection connection = null;

    @BeforeAll
    static void doBefore(){
        try{

            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection("jdbc:h2:~/odontogoPatri;INIT=RUNSCRIPT FROM 'create.sql'","sa","sa");

        }catch (Exception e){
            e.printStackTrace();

        }finally{
            try{
                connection.close();
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }


    }

    OdontologoService odontologoService = new OdontologoService(new OdontologoDaoH2());

    @Test
    void deberiaAgregarUnOdontologo(){

        Odontologo Odont1 = new Odontologo(123456,"Patricia","Sanchez");
        Odontologo odontAgregado = odontologoService.registrarOdontologo(Odont1);

        assertNotNull(odontAgregado.getId());

    }

    @Test
    void deberiaEncontrarOdontologoConId(){

        Odontologo Odont1 = new Odontologo(1036666,"Fredy","Ospina");
        Odontologo odontAgregado = odontologoService.registrarOdontologo(Odont1);

        assertNotNull(odontologoService.buscarOdontologoPorId(1));

    }

    @Test
    void debeMostrarListadoConInfo(){
        Odontologo Odont1 = new Odontologo(123456,"Patricia","Sanchez");
        Odontologo odontAgregado0 = odontologoService.registrarOdontologo(Odont1);
        Odontologo Odont2 = new Odontologo(1036666,"Fredy","Ospina");
        Odontologo odontAgregado1 = odontologoService.registrarOdontologo(Odont2);
        Odontologo Odont3 = new Odontologo(456781,"Esneyder","Sanchez");
        Odontologo odontAgregado2 = odontologoService.registrarOdontologo(Odont3);
        List<Odontologo> odontologTest = odontologoService.listarTodosLosOdontologos();
        //no hay assert
    }

    // Prueba de Dao memoria

    OdontologoService odontologoService1 = new OdontologoService(new OdontologDaoEnMemoria());

 @Test
 void ensayoBusquedaOdontologo(){
     Odontologo Odont1 = new Odontologo(1,4555454,"Esneyder","De Sanchez");
     odontologoService1.registrarOdontologo(Odont1);
     odontologoService1.buscarOdontologoPorId(1);

 }

    @Test
    void debeMostrarListadoConInfoEnMemoria(){
        Odontologo Odont1 = new Odontologo(1,1123456,"Patricia","Sanchez");
        Odontologo Odont2 = new Odontologo(2,1036666,"Fredy","Ospina");
        odontologoService1.registrarOdontologo(Odont1);
        odontologoService1.registrarOdontologo(Odont2);

        List<Odontologo> odontologTest = odontologoService1.listarTodosLosOdontologos();
        //no hay assert
    }


}

