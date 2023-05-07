
package com.portfolio.backend.controllers;

import com.portfolio.backend.DTO.ExperienciaDTO;
import com.portfolio.backend.models.Experiencia;
import com.portfolio.backend.repository.ExperienciaRepository;
import com.portfolio.backend.service.ExperienciaService;


import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/experiencia")
public class ExperienciaController {
    @Autowired
    ExperienciaService experienciaService;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Experiencia>> list(){
        List<Experiencia> list = experienciaService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Experiencia> getById(@PathVariable("id") int id){
        if(!experienciaService.existsById(id))
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        Experiencia experiencia = experienciaService.getOne(id).get();
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody ExperienciaDTO experienciadto){
        if (StringUtils.isBlank(experienciadto.getNombreExperiencia()))
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        if (experienciaService.existsByNombreE(experienciadto.getNombreExperiencia()))
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        
        Experiencia experiencia = new Experiencia(experienciadto.getNombreExperiencia(),
                experienciadto.getTituloExperiencia(),
                experienciadto.getDescripcionExperiencia(),
                experienciadto.getFechaFinalExperiencia(),
                experienciadto.getFechaInicialExperiencia(),
                experienciadto.getImgExperienciaURL());
        experienciaService.save(experiencia);
        
        return new ResponseEntity(HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id,@RequestBody ExperienciaDTO experienciadto){
        //Validaciones si existe el ID
        if(!experienciaService.existsById(id))
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        //Nombre ya existente
        if(experienciaService.existsByNombreE(experienciadto.getNombreExperiencia()) && 
                experienciaService.getByNombreE(experienciadto.getNombreExperiencia())
                        .get().getExperienciaId() != id)
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        //No vacio
        if(StringUtils.isBlank(experienciadto.getNombreExperiencia()))
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        
        Experiencia experiencia = experienciaService.getOne(id).get();
        
        experiencia.setNombreExperiencia(experienciadto.getNombreExperiencia());
        experiencia.setTituloExperiencia(experienciadto.getTituloExperiencia());
        experiencia.setDescripcionExperiencia(experienciadto.getDescripcionExperiencia());
        experiencia.setFechaInicialExperiencia(experienciadto.getFechaInicialExperiencia());
        experiencia.setFechaFinalExperiencia(experienciadto.getFechaFinalExperiencia());
        experiencia.setImgExperienciaURL(experienciadto.getImgExperienciaURL());
        
        experienciaService.save(experiencia);
        return new ResponseEntity(HttpStatus.OK);    
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!experienciaService.existsById(id))
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        experienciaService.delete(id);
        
        return new ResponseEntity(HttpStatus.OK);
    }   
}
