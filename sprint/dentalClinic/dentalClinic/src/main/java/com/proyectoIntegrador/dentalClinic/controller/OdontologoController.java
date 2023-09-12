package com.proyectoIntegrador.dentalClinic.controller;


import com.proyectoIntegrador.dentalClinic.dto.entrada.modificacion.OdontologoModificacionEntradaDto;
import com.proyectoIntegrador.dentalClinic.dto.entrada.odontologo.OdontologoEntradaDto;
import com.proyectoIntegrador.dentalClinic.dto.salida.odontologo.OdontologoSalidaDto;
import com.proyectoIntegrador.dentalClinic.service.IOdontologoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {

    private final IOdontologoService odontologoService;

    public OdontologoController(IOdontologoService odontologoService) {
        this.odontologoService = odontologoService;
    }


    // metodo tipo POST para paciente
    //debemos usar un post mapping
    //los endpoint que no necesitan "Registrar" o cualquier comentario, son los que listan ya que no es util para el usuario
    //@RequestBody es para que trabaje la informacion de java en Json

    @PostMapping("Registrar")
    public ResponseEntity<OdontologoSalidaDto> registrarOdontologo(@Valid @RequestBody OdontologoEntradaDto odontologo){
        return new ResponseEntity<>(odontologoService.guardarOdontologo(odontologo), HttpStatus.CREATED);
    }

    @PutMapping("Actualizar")
    public ResponseEntity<OdontologoSalidaDto> actualizarOdontologo (@Valid @RequestBody OdontologoModificacionEntradaDto odontologoModificado){
        return new ResponseEntity<>(odontologoService.modificarOdontologo(odontologoModificado),HttpStatus.OK);
    }


    //Ejercicio de la mesa clase de APIs. Clase 17


    @GetMapping (path = "/consultaOdontologo/{id}")
    public OdontologoSalidaDto consultarOdontologo (Long id){
        return odontologoService.buscarOdontologoPorId(id);
    }

    @DeleteMapping(path = "/eliminarOdontologo/{id}")
    public void eliminarOdontologo (Long id){
        odontologoService.eliminarOdontologo(id);
    }

    @GetMapping (path = "/consultarTodo")
    public List<OdontologoSalidaDto> listarOdontologo (){
        return odontologoService.listarOdontologos();
    }


}
