package com.proyectoIntegrador.dentalClinic.Controller;


import com.proyectoIntegrador.dentalClinic.entity.Odontologo;
import com.proyectoIntegrador.dentalClinic.entity.Paciente;
import com.proyectoIntegrador.dentalClinic.service.IOdontologoService;
import org.springframework.web.bind.annotation.*;

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
    public Odontologo registrarOdontologo(@RequestBody Odontologo odontologo){
        return odontologoService.guardarOdontologo(odontologo);
    }

    @PutMapping("Actualizar")
    public Odontologo actualizarOdontologo (@RequestBody Odontologo odontologoModificado){
        return odontologoService.modificarOdontologo(odontologoModificado);
    }


    //Ejercicio de la mesa clase de APIs. Clase 17


    @GetMapping (path = "/consultaOdontologo/{id}")
    public Odontologo consultarOdontologo (int id){
        return odontologoService.buscarOdontologoPorId(id);
    }

    @DeleteMapping(path = "/eliminarOdontologo/{id}")
    public void eliminarOdontologo (int id){
        odontologoService.eliminarOdontologo(id);
    }

    @GetMapping (path = "/consultarTodo")
    public List<Odontologo> listarOdontologo (){
        return odontologoService.listarOdontologos();
    }


}
