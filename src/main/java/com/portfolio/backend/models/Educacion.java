
package com.portfolio.backend.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author edwin
 */
@Entity
@Table (name = "tbl_educacion")
public class Educacion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int educacionId;
    
    private String nombreEducacion;
    
    private String descripcionEducacion;
    
    //Construtores

    public Educacion() {
    }

    public Educacion(String nombreEducacion, String descripcionEducacion) {
        this.nombreEducacion = nombreEducacion;
        this.descripcionEducacion = descripcionEducacion;
    }

    public int getEducacionId() {
        return educacionId;
    }

    public void setEducacionId(int educacionId) {
        this.educacionId = educacionId;
    }

    public String getNombreEducacion() {
        return nombreEducacion;
    }

    public void setNombreEducacion(String nombreEducacion) {
        this.nombreEducacion = nombreEducacion;
    }

    public String getDescripcionEducacion() {
        return descripcionEducacion;
    }

    public void setDescripcionEducacion(String descripcionEducacion) {
        this.descripcionEducacion = descripcionEducacion;
    }
    
    
    
}
