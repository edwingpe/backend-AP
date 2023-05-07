package com.portfolio.backend.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author edwin
 */
@Data
@Entity
@Table(name = "tbl_persona")
public class Persona {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Long personaId;
    
    private String firstname;
    
    private String lastname;
    
    private String title;
    
    private String description;
    
    private String profileURL;
    
    private String imageURL;
    
    private String imageURL2;
    
    private String imageURL3;
    
    private String imageURL4;
    
    private String linkedinURL;
    
    private String githubURL;
    
    private String codepenURL;
    
}
