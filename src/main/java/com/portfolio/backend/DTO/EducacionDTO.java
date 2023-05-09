
package com.portfolio.backend.DTO;

import javax.validation.constraints.NotBlank;

/**
 *
 * @author edwin
 */
public class EducacionDTO {
    
    @NotBlank
    private String nombreEducacion;
    @NotBlank
    private String descripcionEducacion;

    public EducacionDTO() {
    }

    public EducacionDTO(String nombreEducacion, String descripcionEducacion) {
        this.nombreEducacion = nombreEducacion;
        this.descripcionEducacion = descripcionEducacion;
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
