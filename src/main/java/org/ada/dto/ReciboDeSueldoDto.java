package org.ada.dto;

public class ReciboDeSueldoDto {

    private int id;
    private String puesto;
    private long sueldo;

    private int idEmpleado;

    public ReciboDeSueldoDto() {
    }

    public ReciboDeSueldoDto(int id, String puesto, long sueldo, int idEmpleado) {
        this.id = id;
        this.puesto = puesto;
        this.sueldo = sueldo;
        this.idEmpleado = idEmpleado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public long getSueldo() {
        return sueldo;
    }

    public void setSueldo(long sueldo) {
        this.sueldo = sueldo;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }
}
