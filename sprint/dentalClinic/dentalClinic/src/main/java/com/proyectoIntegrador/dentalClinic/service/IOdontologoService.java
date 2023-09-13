package com.proyectoIntegrador.dentalClinic.service;

import com.proyectoIntegrador.dentalClinic.dto.entrada.modificacion.OdontologoModificacionEntradaDto;
import com.proyectoIntegrador.dentalClinic.dto.entrada.odontologo.OdontologoEntradaDto;
import com.proyectoIntegrador.dentalClinic.dto.salida.odontologo.OdontologoSalidaDto;

import java.util.List;

public interface IOdontologoService {


     OdontologoSalidaDto guardarOdontologo(OdontologoEntradaDto odontologo);

     OdontologoSalidaDto buscarOdontologoPorId(Long id);

     List<OdontologoSalidaDto> listarOdontologos();

     void eliminarOdontologo(Long id);

     OdontologoSalidaDto modificarOdontologo (OdontologoModificacionEntradaDto modificarOdontologo);

}
