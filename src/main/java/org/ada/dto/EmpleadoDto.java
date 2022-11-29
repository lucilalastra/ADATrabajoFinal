package org.ada.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import org.ada.entity.*;

public class EmpleadoDto {

    private int id;
    private String nombre;
    private String apellido;

    @JsonAlias ("tipo_identificacion")
    private TipoIdentificacion tipoIdentificacion;

    @JsonAlias ("numero_identificacion")
    private int numeroIdentificacion;
    private String domicilio;

    @JsonAlias ("correo_electronico")
    private String correoElectronico;

    @JsonAlias ("numero_telefono")
    private String numeroTelefono;

    @JsonAlias ("fecha_ingreso")
    private String fechaIngreso;

    @JsonAlias ("tipo_contrato")
    private TipoContrato tipoContrato;

    private Status status;

    public EmpleadoDto(int id, String nombre, String apellido, TipoIdentificacion tipoIdentificacion,
                       int numeroIdentificacion, String domicilio, String correoElectronico,
                       String numeroTelefono, String fechaIngreso, TipoContrato tipoContrato, Status status) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipoIdentificacion = tipoIdentificacion;
        this.numeroIdentificacion = numeroIdentificacion;
        this.domicilio = domicilio;
        this.correoElectronico = correoElectronico;
        this.numeroTelefono = numeroTelefono;
        this.fechaIngreso = fechaIngreso;
        this.tipoContrato = tipoContrato;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public TipoIdentificacion getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(TipoIdentificacion tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public int getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public void setNumeroIdentificacion(int numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }


    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public TipoContrato getTipoContrato() {
        return tipoContrato;
    }

    public void setTipoContrato(TipoContrato tipoContrato) {
        this.tipoContrato = tipoContrato;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
