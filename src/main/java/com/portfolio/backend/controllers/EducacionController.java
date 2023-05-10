
package com.portfolio.backend.controllers;


import com.portfolio.backend.DTO.EducacionDTO;
import com.portfolio.backend.models.Educacion;
import com.portfolio.backend.service.EducacionService;
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
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = {"http://localhost:4200", "https://frontend-ap-e3657.web.app"})
@RequestMapping(path = "/educacion")
public class EducacionController {
    @Autowired
    EducacionService educacionService;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Educacion>> list(){
        List<Educacion> list = educacionService.list();
        return new ResponseEntity(list,HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Educacion> getById(@PathVariable("id") int id){
        if(!educacionService.existsById(id))
            return new ResponseEntity("Educacion no encontrada",HttpStatus.NOT_FOUND);
        Educacion educacion = educacionService.getOne(id).get();
        return new ResponseEntity(educacion, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if(!educacionService.existsById(id))
            return new ResponseEntity("No existe el ID",HttpStatus.BAD_REQUEST);
        educacionService.delete(id);
        
        return new ResponseEntity("Educacion Eliminada",HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody EducacionDTO educaciondto){
        if (StringUtils.isBlank(educaciondto.getNombreEducacion()))
            return new ResponseEntity("Nombre obligatorio",HttpStatus.BAD_REQUEST);
        if (educacionService.existsByNombreEducacion(educaciondto.getNombreEducacion()))
            return new ResponseEntity("Nombre existente",HttpStatus.BAD_REQUEST);
        
        Educacion educacion = new Educacion(educaciondto.getNombreEducacion(),
                educaciondto.getDescripcionEducacion());
                
        educacionService.save(educacion);
        return new ResponseEntity("Educacion creada.",HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id,@RequestBody EducacionDTO educaciondto){
        //Validaciones si existe el ID
        if(!educacionService.existsById(id))
            return new ResponseEntity("No existe el id.",HttpStatus.BAD_REQUEST);
        //Nombre ya existente
        if(educacionService.existsByNombreEducacion(educaciondto.getNombreEducacion()) && 
                educacionService.getByNombreEducacion(educaciondto.getNombreEducacion())
                        .get().getEducacionId() != id)
            return new ResponseEntity("Nombre de educacion existente",HttpStatus.BAD_REQUEST);
        //No vacio
        if(StringUtils.isBlank(educaciondto.getNombreEducacion()))
            return new ResponseEntity("El campo nombre, no puede estar vacio",HttpStatus.BAD_REQUEST);
        
        Educacion educacion = educacionService.getOne(id).get();
        
        educacion.setNombreEducacion(educaciondto.getNombreEducacion());
        educacion.setDescripcionEducacion(educaciondto.getDescripcionEducacion());
        
        educacionService.save(educacion);
        return new ResponseEntity("Educacion actualizada",HttpStatus.OK);    
    }
    
}
