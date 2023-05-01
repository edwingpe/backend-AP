
package com.portfolio.backend.service;

import com.portfolio.backend.models.Persona;
import com.portfolio.backend.repository.PersonaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author edwin
 */
@Service
public class PersonaService {
    @Autowired
    PersonaRepository personaRepository;
    
    public List<Persona> getPersonas(){
        return personaRepository.findAll();
    }
    
    public Optional<Persona> getPersona(Long id){
        return personaRepository.findById(id);    
    }
    
    public void saveOrUpdate(Persona persona){
        personaRepository.save(persona);
    }
    
    public void delete(Long id){
        personaRepository.deleteById(id);
    }
    
    
    
    
}
