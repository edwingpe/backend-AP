
package com.portfolio.backend.DTO;

import javax.validation.constraints.NotBlank;
import lombok.Data;

/**
 *
 * @author edwin
 */

public class ExperienciaDTO {
    
    @NotBlank
    private String nombreExperiencia;
    @NotBlank
    private String descripcionExperiencia;
    @NotBlank
    private String tituloExperiencia;
    
    private String fechaInicialExperiencia;
    
    private String fechaFinalExperiencia;
    
    private String imgExperienciaURL;
    
    //Constructor

    public ExperienciaDTO() {
    }

    public ExperienciaDTO(String nombreExperiencia, String descripcionExperiencia, String tituloExperiencia, String fechaInicialExperiencia, String fechaFinalExperiencia, String imgExperienciaURL) {
        this.nombreExperiencia = nombreExperiencia;
        this.descripcionExperiencia = descripcionExperiencia;
        this.tituloExperiencia = tituloExperiencia;
        this.fechaInicialExperiencia = fechaInicialExperiencia;
        this.fechaFinalExperiencia = fechaFinalExperiencia;
        this.imgExperienciaURL = imgExperienciaURL;
    }

    public String getNombreExperiencia() {
        return nombreExperiencia;
    }

    public void setNombreExperiencia(String nombreExperiencia) {
        this.nombreExperiencia = nombreExperiencia;
    }

    public String getDescripcionExperiencia() {
        return descripcionExperiencia;
    }

    public void setDescripcionExperiencia(String descripcionExperiencia) {
        this.descripcionExperiencia = descripcionExperiencia;
    }

    public String getTituloExperiencia() {
        return tituloExperiencia;
    }

    public void setTituloExperiencia(String tituloExperiencia) {
        this.tituloExperiencia = tituloExperiencia;
    }

    public String getFechaInicialExperiencia() {
        return fechaInicialExperiencia;
    }

    public void setFechaInicialExperiencia(String fechaInicialExperiencia) {
        this.fechaInicialExperiencia = fechaInicialExperiencia;
    }

    public String getFechaFinalExperiencia() {
        return fechaFinalExperiencia;
    }

    public void setFechaFinalExperiencia(String fechaFinalExperiencia) {
        this.fechaFinalExperiencia = fechaFinalExperiencia;
    }

    public String getImgExperienciaURL() {
        return imgExperienciaURL;
    }

    public void setImgExperienciaURL(String imgExperienciaURL) {
        this.imgExperienciaURL = imgExperienciaURL;
    }
    
    
       
}
