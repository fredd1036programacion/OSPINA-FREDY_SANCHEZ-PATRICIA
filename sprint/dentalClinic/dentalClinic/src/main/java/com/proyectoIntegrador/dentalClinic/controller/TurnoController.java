package com.proyectoIntegrador.dentalClinic.controller;

import com.proyectoIntegrador.dentalClinic.dto.entrada.modificacion.PacienteModificacionEntradaDto;
import com.proyectoIntegrador.dentalClinic.dto.entrada.modificacion.TurnoModificacionEntradaDto;
import com.proyectoIntegrador.dentalClinic.dto.entrada.turno.TurnoEntradaDto;
import com.proyectoIntegrador.dentalClinic.dto.salida.paciente.PacienteSalidaDto;
import com.proyectoIntegrador.dentalClinic.dto.salida.turno.TurnoSalidaDto;
import com.proyectoIntegrador.dentalClinic.service.ITurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/turnos")
public class TurnoController {

private ITurnoService turnoService;

@Autowired

    public TurnoController(ITurnoService turnoService) {
        this.turnoService = turnoService;
    }

    //POST
    @PostMapping("/registrar")
    public ResponseEntity<TurnoSalidaDto> registrarTurno(@Valid @RequestBody TurnoEntradaDto turnoEntradaDto){
    return new ResponseEntity<>(turnoService.registrarTurno(turnoEntradaDto), HttpStatus.CREATED);
    }

    @PutMapping("/actualizar")
    public ResponseEntity<TurnoSalidaDto> actualizarTurno (@Valid @RequestBody TurnoModificacionEntradaDto turno){
        return new ResponseEntity<> (turnoService.modificarTurno(turno), HttpStatus.OK);
    }

    @GetMapping (path = "consultaturno/{id}")
    public TurnoSalidaDto consultarTurno (Long id){
        return turnoService.buscarTurnoPorId(id);
    }

    @DeleteMapping(path = "eliminarTurno/{id}")
    public void  eliminarTurno (@Valid Long id){
        turnoService.eliminarTurno(id);
    }

    @GetMapping ()
    public List<TurnoSalidaDto> listarTurno (){
        return turnoService.listarTurno();
    }

    @GetMapping("holaTurno")
    public String saludar(){
        String saludo = "prueba q funciona la api de fredyTurno";
        return saludo;
    }

}
