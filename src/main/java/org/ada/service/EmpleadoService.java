package org.ada.service;

import org.ada.dto.EmpleadoDto;
import org.ada.entity.Empleado;
import org.ada.entity.ObraSocial;
import org.ada.entity.RazonSocial;
import org.ada.repository.EmpleadoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmpleadoService {


    static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    private final EmpleadoRepository empleadoRepository;

    public EmpleadoService(EmpleadoRepository empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }

    public EmpleadoDto create (EmpleadoDto empleadoDto) {
        Empleado empleado = mapToEntity (empleadoDto);
        empleadoRepository.save(empleado);
        return empleadoDto;
    }

    public List<EmpleadoDto> retrieveAll(){
        List<Empleado> empleados = empleadoRepository.findAll();

        return empleados.stream()
                .map(empleado -> mapToDTO(empleado))
                .collect(Collectors.toList());
    }

    public EmpleadoDto consultarEmpleadoId(Integer id) throws Exception{
        Optional<Empleado> empleado = empleadoRepository.findById(id);
        if (!empleado.isPresent()){
            throw new RuntimeException("El empleado consultado no existe.");
        }

        return mapToDTO(empleado.get());
    }

    public void eliminarEmpleadoId(Integer id) throws Exception {
        empleadoRepository.deleteById(id);
    }

    private Empleado mapToEntity(EmpleadoDto empleadoDto) {
        RazonSocial razonSocial = new RazonSocial(1, "1212121212", "Lula SA", "domicilio", new ArrayList<>());
        ObraSocial obraSocial = new ObraSocial(155, "25-36789-6", "osecac", "laprida 123");
        Empleado empleado = new Empleado(empleadoDto.getId(), empleadoDto.getNombre(), empleadoDto.getApellido(),
                empleadoDto.getTipoIdentificacion(), empleadoDto.getNumeroIdentificacion(), empleadoDto.getDomicilio(),
                empleadoDto.getCorreoElectronico(), empleadoDto.getNumeroTelefono(),
                LocalDate.parse(empleadoDto.getFechaIngreso(), DATE_TIME_FORMATTER),
                empleadoDto.getTipoContrato(), empleadoDto.getStatus());

        return empleado;
    }

    private EmpleadoDto mapToDTO(Empleado empleado) {
        EmpleadoDto empleadoDto = new EmpleadoDto(empleado.getId(), empleado.getNombre(), empleado.getApellido(),
                empleado.getTipoIdentificacion(), empleado.getNumeroIdentificacion(), empleado.getDomicilio(),
                empleado.getCorreoElectronico(), empleado.getNumeroTelefono(), empleado.getFechaIngreso().toString(),
                empleado.getTipoContrato(), empleado.getStatus());

        return empleadoDto;
    }
}
