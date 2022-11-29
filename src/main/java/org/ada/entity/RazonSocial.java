package org.ada.entity;

import javax.persistence.*;
import java.util.List;

@Entity (name = "razon_social")
public class RazonSocial {

    @Id
    @Column
    private int id;

    @Column
    private String cuit;

    @Column
    private String nombre;

    @Column (name = "domicilio_legal")
    private String domicilioLegal;

    @OneToMany (fetch = FetchType.LAZY)
    @JoinColumn (name = "razon_social_id")
    private List<Empleado> empleados;
    public RazonSocial(int id, String cuit, String nombre, String domicilioLegal, List<Empleado> empleados) {
        this.id = id;
        this.cuit = cuit;
        this.nombre = nombre;
        this.domicilioLegal = domicilioLegal;
        this.empleados = empleados;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDomicilioLegal() {
        return domicilioLegal;
    }

    public void setDomicilioLegal(String domicilioLegal) {
        this.domicilioLegal = domicilioLegal;
    }
}
