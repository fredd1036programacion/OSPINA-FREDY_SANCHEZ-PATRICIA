package com.proyectoIntegrador.dentalClinic.Controller;


import com.proyectoIntegrador.dentalClinic.service.IOdontologoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {

    private final IOdontologoService odontologoService;

    public OdontologoController(IOdontologoService odontologoService) {
        this.odontologoService = odontologoService;
    }
}
