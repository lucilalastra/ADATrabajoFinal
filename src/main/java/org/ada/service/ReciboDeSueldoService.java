package org.ada.service;

import org.ada.dto.ReciboDeSueldoDto;
import org.ada.entity.Empleado;
import org.ada.entity.ReciboDeSueldo;
import org.ada.repository.ReciboDeSueldoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReciboDeSueldoService {

    private final ReciboDeSueldoRepository reciboDeSueldoRepository;


    public ReciboDeSueldoService(ReciboDeSueldoRepository reciboDeSueldoRepository) {
        this.reciboDeSueldoRepository = reciboDeSueldoRepository;
    }

    public List<ReciboDeSueldoDto> consultarTodos () {
        return reciboDeSueldoRepository.findAll().stream()
                .map(recibo -> mapToDto(recibo))
                .collect(Collectors.toList());
    }
    public List<ReciboDeSueldoDto> mapToDtos (List<ReciboDeSueldo> reciboDeSueldos) {
        return reciboDeSueldos.stream()
                .map(recibo -> mapToDto(recibo))
                .collect(Collectors.toList());
    }
    public ReciboDeSueldoDto mapToDto (ReciboDeSueldo reciboDeSueldo) {
        return new ReciboDeSueldoDto(reciboDeSueldo.getId(), reciboDeSueldo.getPuesto(), reciboDeSueldo.getSueldo(), reciboDeSueldo.getEmpleado().getId());
    }

    public List<ReciboDeSueldo> mapToEntitys (List<ReciboDeSueldoDto> reciboDeSueldoDtos, Empleado empleado) {
        return reciboDeSueldoDtos.stream()
                .map(recibo -> mapToEntity(recibo, empleado))
                .collect(Collectors.toList());
    }

    public ReciboDeSueldo mapToEntity (ReciboDeSueldoDto reciboDeSueldoDto, Empleado empleado) {
        return new ReciboDeSueldo(reciboDeSueldoDto.getId(), reciboDeSueldoDto.getPuesto(), reciboDeSueldoDto.getSueldo(), empleado);
    }
}
