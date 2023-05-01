
package com.portfolio.backend.controllers;

import com.portfolio.backend.models.Persona;
import com.portfolio.backend.service.PersonaService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author edwin
 */
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
@RestController
@RequestMapping(path = "api/personas")
public class PersonaController {
    
    @Autowired
    private PersonaService personaService;
    
    @GetMapping
    public List<Persona> getAll(){
        return personaService.getPersonas();
    }
    
    @GetMapping("/{personaId}")
    public Optional<Persona> getById(@PathVariable("personaId") Long personaId){
        return personaService.getPersona(personaId);
    }
    
    @PostMapping
    public void saveUpdate(@RequestBody Persona persona){
        personaService.saveOrUpdate(persona);
    }
    
    @DeleteMapping("/{personaId}")
    public void saveUpdate(@PathVariable("personaId") Long personaId){
        personaService.delete(personaId);
    }
    
}
