package org.ada.service;

import org.ada.dto.EmpleadoDto;
import org.ada.dto.LegajoDto;
import org.ada.entity.Empleado;
import org.ada.entity.Legajo;
import org.ada.entity.ReciboDeSueldo;
import org.ada.exception.ResourceNotFoundException;
import org.ada.repository.EmpleadoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmpleadoService {


    static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    private final EmpleadoRepository empleadoRepository;

    private final ReciboDeSueldoService reciboDeSueldoService;

    public EmpleadoService(EmpleadoRepository empleadoRepository, ReciboDeSueldoService reciboDeSueldoService) {
        this.empleadoRepository = empleadoRepository;
        this.reciboDeSueldoService = reciboDeSueldoService;
    }

    public EmpleadoDto create (EmpleadoDto empleadoDto) {
        Empleado empleado = mapToEntity (empleadoDto); //mapeo dto a entidad
        empleadoRepository.save(empleado);
        return empleadoDto;
    }

    public List<EmpleadoDto> consultarTodos(){
        List<Empleado> empleados = empleadoRepository.findAll(); //buscar todos empleados

        return empleados.stream()
                .map(empleado -> mapToDTO(empleado))
                .collect(Collectors.toList());
    }

    public EmpleadoDto consultarEmpleadoId(Integer id) throws Exception{
        Optional<Empleado> empleado = empleadoRepository.findById(id);
        if (!empleado.isPresent()){
            throw new ResourceNotFoundException("El empleado consultado no existe.");
        }

        return mapToDTO(empleado.get());
    }

    public void eliminarEmpleadoId(Integer id) throws Exception {
        empleadoRepository.deleteById(id); //si no encuentra, lanza excepción
    }

    private Empleado mapToEntity(EmpleadoDto empleadoDto) {
        Empleado empleado = new Empleado(empleadoDto.getId(), empleadoDto.getNombre(), empleadoDto.getApellido(),
                empleadoDto.getTipoIdentificacion(), empleadoDto.getNumeroIdentificacion(), empleadoDto.getDomicilio(),
                empleadoDto.getCorreoElectronico(), empleadoDto.getNumeroTelefono(),
                LocalDate.parse(empleadoDto.getFechaIngreso(), DATE_TIME_FORMATTER),
                empleadoDto.getTipoContrato(), empleadoDto.getStatus());

        List<ReciboDeSueldo> reciboDeSueldos = reciboDeSueldoService.mapToEntitys(empleadoDto.getRecibosDeSueldo(), empleado);
        Legajo legajo = convertirALegajo(empleadoDto.getLegajoDto(), empleado);

        empleado.setLegajo(legajo);
        empleado.setReciboDeSueldos(reciboDeSueldos);

        return empleado;
    }

    private EmpleadoDto mapToDTO(Empleado empleado) {

        LegajoDto legajoDto = null;
        if (empleado.getLegajo() != null) {
            legajoDto = convertirLegDto(empleado.getLegajo());
        }

        EmpleadoDto empleadoDto = new EmpleadoDto(empleado.getId(), empleado.getNombre(), empleado.getApellido(),
                empleado.getTipoIdentificacion(), empleado.getNumeroIdentificacion(), empleado.getDomicilio(),
                empleado.getCorreoElectronico(), empleado.getNumeroTelefono(), empleado.getFechaIngreso().toString(),
                empleado.getTipoContrato(), empleado.getStatus(), reciboDeSueldoService.mapToDtos(empleado.getReciboDeSueldos()),
                legajoDto);

        return empleadoDto;
    }

    public LegajoDto convertirLegDto (Legajo legajo){
        return new LegajoDto(legajo.getId(), legajo.getNumeroLegajo(), legajo.getEmpleado().getId());
    }

    public Legajo convertirALegajo(LegajoDto legajoDto, Empleado empleado){
        return new Legajo(legajoDto.getId(), legajoDto.getNumeroLegajo(), empleado);
    }
}
