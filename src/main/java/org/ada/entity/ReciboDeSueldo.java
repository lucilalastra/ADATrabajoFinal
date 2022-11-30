package org.ada.entity;

import javax.persistence.*;

@Entity(name = "recibo_de_sueldo")
public class ReciboDeSueldo {

    @Id
    private int id;

    @Column
    private String puesto;

    @Column
    private long sueldo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "empleado_id", nullable = false)
    private Empleado empleado;

    public ReciboDeSueldo() {
    }

    public ReciboDeSueldo(int id, String puesto, long sueldo, Empleado empleado) {
        this.id = id;
        this.puesto = puesto;
        this.sueldo = sueldo;
        this.empleado = empleado;
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

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
}
