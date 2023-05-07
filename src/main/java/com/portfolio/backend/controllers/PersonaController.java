package com.portfolio.backend.controllers;

import com.portfolio.backend.models.Persona;
import com.portfolio.backend.service.PersonaService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author edwin
 */
//@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
@RestController
@RequestMapping(path = "api/personas")
public class PersonaController {
    
    @Autowired
    private PersonaService personaService;
    
    @GetMapping("/traer")
    public List<Persona> getAll(){
        return personaService.getPersonas();
    }
    
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/crear")
    public String crearPersona(@RequestBody Persona persona){
        personaService.saveOrUpdate(persona);
        return "Persona creada correctamente";
    }
    
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/borrar/{id}")
    public String borrarPersona(@PathVariable Long id){
        personaService.delete(id);
        return "Persona Eliminada";
    }
    
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping
    public void saveUpdate(@RequestBody Persona persona){
        personaService.saveOrUpdate(persona);
    }
    
    
    @GetMapping("/{personaId}")
    public Optional<Persona> getById(@PathVariable("personaId") Long personaId){
        return personaService.getPersona(personaId);
    }
    

    
}
