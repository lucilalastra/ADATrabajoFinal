package org.ada.entity;

import javax.persistence.*;
import java.util.List;

@Entity (name = "obra_social")
public class ObraSocial {

    @Id
    @Column
    private int id;

    @Column
    private String cuit;

    @Column
    private String nombre;

    @Column (name = "domicilio_legal")
    private String domicilioLegal;


    public ObraSocial(int id, String cuit, String nombre, String domicilioLegal) {
        this.id = id;
        this.cuit = cuit;
        this.nombre = nombre;
        this.domicilioLegal = domicilioLegal;
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
