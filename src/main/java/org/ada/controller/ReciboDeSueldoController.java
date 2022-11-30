package org.ada.controller;

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
}
