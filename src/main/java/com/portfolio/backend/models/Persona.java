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
@Table(name = "tbl_persona")
public class Persona {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String nombre;
    
    private String apellido;
    
    private String titulo;
    
    private String descripcion;
    
    private String profileURL;
    
    private String imageURL;
    
    private String imageURL2;
    
    private String imageURL3;
    
    private String imageURL4;
    
    private String linkedinURL;
    
    private String githubURL;
    
    private String codepenURL;

    public Persona() {
    }

    public Persona(String nombre, String apellido, String titulo, String descripcion, String profileURL, String imageURL, String imageURL2, String imageURL3, String imageURL4, String linkedinURL, String githubURL, String codepenURL) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.profileURL = profileURL;
        this.imageURL = imageURL;
        this.imageURL2 = imageURL2;
        this.imageURL3 = imageURL3;
        this.imageURL4 = imageURL4;
        this.linkedinURL = linkedinURL;
        this.githubURL = githubURL;
        this.codepenURL = codepenURL;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getProfileURL() {
        return profileURL;
    }

    public void setProfileURL(String profileURL) {
        this.profileURL = profileURL;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getImageURL2() {
        return imageURL2;
    }

    public void setImageURL2(String imageURL2) {
        this.imageURL2 = imageURL2;
    }

    public String getImageURL3() {
        return imageURL3;
    }

    public void setImageURL3(String imageURL3) {
        this.imageURL3 = imageURL3;
    }

    public String getImageURL4() {
        return imageURL4;
    }

    public void setImageURL4(String imageURL4) {
        this.imageURL4 = imageURL4;
    }

    public String getLinkedinURL() {
        return linkedinURL;
    }

    public void setLinkedinURL(String linkedinURL) {
        this.linkedinURL = linkedinURL;
    }

    public String getGithubURL() {
        return githubURL;
    }

    public void setGithubURL(String githubURL) {
        this.githubURL = githubURL;
    }

    public String getCodepenURL() {
        return codepenURL;
    }

    public void setCodepenURL(String codepenURL) {
        this.codepenURL = codepenURL;
    }

    
    
    
    
}
