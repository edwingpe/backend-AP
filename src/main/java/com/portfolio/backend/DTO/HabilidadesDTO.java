
package com.portfolio.backend.DTO;

import javax.validation.constraints.NotBlank;

/**
 *
 * @author edwin
 */
public class HabilidadesDTO {
    @NotBlank
    private String nombre;
    @NotBlank
    private int porcentaje;

    public HabilidadesDTO() {
    }

    public HabilidadesDTO(String nombre, int porcentaje) {
        this.nombre = nombre;
        this.porcentaje = porcentaje;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }
    
    
    
    
}
