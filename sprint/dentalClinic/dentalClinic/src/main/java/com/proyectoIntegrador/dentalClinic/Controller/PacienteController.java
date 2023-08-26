package com.proyectoIntegrador.dentalClinic.Controller;

import com.proyectoIntegrador.dentalClinic.entity.Paciente;
import com.proyectoIntegrador.dentalClinic.service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")

public class PacienteController {

    private final IPacienteService pacienteService;

    @Autowired
    public PacienteController(IPacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    // metodo tipo POST para paciente
    //debemos usar un post mapping
    //los endpoint que no necesitan "Registrar" o cualquier comentario, son los que listan ya que no es util para el usuario
    //@RequestBody es para que trabaje la informacion de java en Json

    @PostMapping ("Registrar")
    public Paciente registrarPaciente(@RequestBody Paciente paciente){
        return pacienteService.registrarPaciente(paciente);
    }

    @PutMapping("Actualizar")
    public Paciente actualizarPaciente (@RequestBody Paciente pacienteModificado){
        return pacienteService.modificarPaciente(pacienteModificado);
    }


    //Ejercicio de la mesa clase de APIs. Clase 17


    @GetMapping (path = "/consultaPaciente/{id}")
        public Paciente consultarPaciente (int id){
        return pacienteService.buscarPacientePorId(id);
    }

    @DeleteMapping(path = "/eliminarPaciente/{id}")
        public void eliminarPaciente (int id){
            pacienteService.eliminarPaciente(id);
    }

    @GetMapping (path = "/consultarTodo")
    public List<Paciente> listarPaciente (){
        return pacienteService.listarPacientes();
    }
}

