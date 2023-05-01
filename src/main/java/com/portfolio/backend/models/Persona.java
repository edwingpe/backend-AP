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
    
    private String firstName;
    
    private String lastName;
    
    private String description;
    
    private String imageURL;
    
}
