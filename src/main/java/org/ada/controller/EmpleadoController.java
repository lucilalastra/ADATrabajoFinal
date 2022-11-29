package org.ada.controller;

import org.ada.dto.EmpleadoDto;
import org.ada.service.EmpleadoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping (path = "/empleado")
public class EmpleadoController {

    private final EmpleadoService empleadoService;

    public EmpleadoController (EmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }

    @PostMapping
    public ResponseEntity crearEmpleado (@RequestBody EmpleadoDto empleadoDto) {
        EmpleadoDto empleadoCreado = empleadoService.create(empleadoDto);

        return new ResponseEntity(empleadoCreado.getId(), HttpStatus.CREATED);

    }

    @GetMapping
    public ResponseEntity consultarEmpleados() {

        return new ResponseEntity(empleadoService.retrieveAll(), HttpStatus.OK);
    }

    @GetMapping("/{empleadoId}")
    public ResponseEntity consultarEmpleadoId(@PathVariable Integer empleadoId){
        try {
            EmpleadoDto empleadoDto = empleadoService.consultarEmpleadoId(empleadoId);

            return new ResponseEntity(empleadoDto, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity("Empleado no encontrado", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{empleadoId}")
    public ResponseEntity eliminarEmpleadoId(@PathVariable Integer empleadoId) {
        try {
            empleadoService.eliminarEmpleadoId(empleadoId);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity("Empleado no encontrado", HttpStatus.NOT_FOUND);
        }
    }
}
