package org.ada.dto;

import com.fasterxml.jackson.annotation.JsonAlias;

public class LegajoDto {

    private int id;
    @JsonAlias("numero_legajo")
    private int numeroLegajo;
    private int idEmpleado;

    public LegajoDto() {
    }

    public LegajoDto(int id, int numeroLegajo, int idEmpleado) {
        this.id = id;
        this.numeroLegajo = numeroLegajo;
        this.idEmpleado = idEmpleado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumeroLegajo() {
        return numeroLegajo;
    }

    public void setNumeroLegajo(int numeroLegajo) {
        this.numeroLegajo = numeroLegajo;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }
}
