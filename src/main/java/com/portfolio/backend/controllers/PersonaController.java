package com.portfolio.backend.controllers;

import com.portfolio.backend.DTO.PersonaDTO;
import com.portfolio.backend.models.Persona;
import com.portfolio.backend.service.PersonaService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@CrossOrigin(origins = {"http://localhost:4200", "https://frontend-ap-e3657.web.app"})
@RestController
@RequestMapping(path = "/api/personas")
public class PersonaController {
    
    @Autowired
    PersonaService personaService;
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody PersonaDTO personadto){
        Persona persona = new Persona (
                personadto.getNombre(),
                personadto.getApellido(),
                personadto.getTitulo(),
                personadto.getDescripcion(),
                personadto.getImageURL(),
                personadto.getImageURL2(),
                personadto.getImageURL3(),
                personadto.getImageURL4(),
                personadto.getLinkedinURL(),
                personadto.getCodepenURL(),
                personadto.getGithubURL(),
                personadto.getProfileURL());
        personaService.save(persona);
        return new ResponseEntity("Persona Creada", HttpStatus.OK);
    }
    
    @GetMapping("/traer")
    public ResponseEntity <List<Persona>> list(){
        List<Persona> list = personaService.list();
        return new ResponseEntity(list,HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Persona> getById(@PathVariable("id") int id){
        if(!personaService.existsById(id)){
            return new ResponseEntity("No existe el ID", HttpStatus.OK);
        }
        Persona persona = personaService.getOne(id).get();
        return new ResponseEntity(persona, HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id,@RequestBody PersonaDTO personadto){
        Persona persona = personaService.getOne(id).get();
        
        persona.setNombre(personadto.getNombre());
        persona.setApellido(personadto.getApellido());
        persona.setTitulo(personadto.getTitulo());
        persona.setDescripcion(personadto.getDescripcion());
        persona.setImageURL(personadto.getImageURL());
        persona.setImageURL2(personadto.getImageURL2());
        persona.setImageURL3(personadto.getImageURL3());
        persona.setImageURL4(personadto.getImageURL4());
        persona.setCodepenURL(personadto.getCodepenURL());
        persona.setGithubURL(personadto.getGithubURL());
        persona.setLinkedinURL(personadto.getLinkedinURL());
        
        personaService.save(persona);
     
        
        return new ResponseEntity("Persona actualizada", HttpStatus.OK);

    }  
}
