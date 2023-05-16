
package com.portfolio.backend.controllers;

import com.portfolio.backend.DTO.ProyectoDTO;
import com.portfolio.backend.models.Proyecto;
import com.portfolio.backend.service.ProyectoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author edwin
 */

@RestController
@CrossOrigin(origins = {"http://localhost:4200", "https://frontend-ap-e3657.web.app"})
@RequestMapping(path = "/proyecto")
public class ProyectoController {
    @Autowired
    ProyectoService proyectoService;
    
    @GetMapping("/all")
    public ResponseEntity<List<Proyecto>> list(){
        List<Proyecto> list = proyectoService.list();
        return new ResponseEntity(list,HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Proyecto> getById(@PathVariable("id")int id){
        Proyecto proyecto = proyectoService.getOne(id).get();
        return new ResponseEntity(proyecto, HttpStatus.OK);
    }
    
    @PostMapping("/new")
    public ResponseEntity<?> create(@RequestBody ProyectoDTO proyectodto){
        Proyecto proyecto = new Proyecto(proyectodto.getNombre(),
        proyectodto.getImgUrl(),
        proyectodto.getUrl());
        proyectoService.save(proyecto);
        return new ResponseEntity(HttpStatus.OK);  
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody ProyectoDTO proyectodto){
        Proyecto proyecto = proyectoService.getOne(id).get();
        
        proyecto.setNombre(proyectodto.getNombre());
        proyecto.setImgURL(proyectodto.getImgUrl());
        proyecto.setUrl(proyectodto.getUrl());
        
        proyectoService.save(proyecto);
        
        return new ResponseEntity(HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        proyectoService.delete(id);
        
        return new ResponseEntity(HttpStatus.OK);
    }
}
