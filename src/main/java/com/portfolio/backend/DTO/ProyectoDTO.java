
package com.portfolio.backend.DTO;

/**
 *
 * @author edwin
 */
public class ProyectoDTO {
    
    private String nombre;
    
    private String url;
    
    private String imgUrl;

    public ProyectoDTO() {
    }

    public ProyectoDTO(String nombre, String url, String imgUrl) {
        this.nombre = nombre;
        this.url = url;
        this.imgUrl = imgUrl;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
    
    
    
}
