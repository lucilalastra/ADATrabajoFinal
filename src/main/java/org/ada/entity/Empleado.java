package org.ada.entity;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "empleado")
public class Empleado {

    @Id
    @Column (nullable = false)
    private int id;

    @Column
    private String nombre;

    @Column
    private String apellido;

    @Enumerated(EnumType.STRING)
    @Column (name = "tipo_identificacion")
    private TipoIdentificacion tipoIdentificacion;

    @Column (name = "numero_identificacion")
    private int numeroIdentificacion;

    @Column
    private String domicilio;

    @Column (name = "correo_electronico")
    private String correoElectronico;

    @Column (name = "numero_telefono")
    private String numeroTelefono;

    @Column (name = "fecha_ingreso")
    private LocalDate fechaIngreso;

    @Enumerated(EnumType.STRING)
    @Column (name = "tipo_contrato")
    private TipoContrato tipoContrato;

    @Enumerated(EnumType.STRING)
    @Column
    private Status status;

    @OneToMany(mappedBy = "empleado", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<ReciboDeSueldo> reciboDeSueldos;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "legajo_id", referencedColumnName = "id")
    private Legajo legajo;

    public Empleado() {
    }

    public Empleado(int id, String nombre, String apellido, TipoIdentificacion tipoIdentificacion, int numeroIdentificacion,
                    String domicilio, String correoElectronico, String numeroTelefono,
                    LocalDate fechaIngreso, TipoContrato tipoContrato, Status status) {
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

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
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

    public List<ReciboDeSueldo> getReciboDeSueldos() {
        return reciboDeSueldos;
    }

    public void setReciboDeSueldos(List<ReciboDeSueldo> reciboDeSueldos) {
        this.reciboDeSueldos = reciboDeSueldos;
    }

    public Legajo getLegajo() {
        return legajo;
    }

    public void setLegajo(Legajo legajo) {
        this.legajo = legajo;
    }
}
