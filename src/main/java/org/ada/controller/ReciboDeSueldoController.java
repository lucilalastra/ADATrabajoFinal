package org.ada.controller;

import org.ada.dto.EmpleadoDto;
import org.ada.dto.ReciboDeSueldoDto;
import org.ada.service.ReciboDeSueldoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/recibo")
public class ReciboDeSueldoController {

    private final ReciboDeSueldoService reciboDeSueldoService;

    public ReciboDeSueldoController(ReciboDeSueldoService reciboDeSueldoService) {
        this.reciboDeSueldoService = reciboDeSueldoService;
    }

    @GetMapping
    public ResponseEntity consultarTodosLosRecibos() throws Exception {
        List<ReciboDeSueldoDto> recibosDeSueldo = reciboDeSueldoService.consultarTodos();
        return new ResponseEntity(recibosDeSueldo, HttpStatus.OK);
    }

    @GetMapping("/{reciboSueldoId}")
    public ResponseEntity consultarReciboId(@PathVariable Integer reciboSueldoId) throws Exception {
        ReciboDeSueldoDto reiciboDeSueldoDto = reciboDeSueldoService.consultarReciboSueldoId(reciboSueldoId);

        return new ResponseEntity(reiciboDeSueldoDto, HttpStatus.OK);
    }

    @DeleteMapping("/{reciboSueldoId}")
    public ResponseEntity eliminarReciboSueldoId(@PathVariable Integer reciboSueldoId) {
        try {
            reciboDeSueldoService.eliminarReciboSueldoId(reciboSueldoId);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity("Recibo de Sueldo no encontrado", HttpStatus.NOT_FOUND);
        }
    }
}
