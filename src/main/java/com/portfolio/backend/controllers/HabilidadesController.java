package com.portfolio.backend.controllers;

import com.portfolio.backend.DTO.HabilidadesDTO;
import com.portfolio.backend.models.Habilidades;
import com.portfolio.backend.service.HabilidadesService;
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
@CrossOrigin(origins = {"http://localhost:4200", "https://frontend-ap-e3657.web.app"})
@RequestMapping("/habilidades")
public class HabilidadesController {

    @Autowired
    HabilidadesService habilidadesService;

    @GetMapping("/lista")
    public ResponseEntity<List<Habilidades>> list() {
        List<Habilidades> list = habilidadesService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Habilidades> getById(@PathVariable("id") int id) {
        if (!habilidadesService.existsById(id)) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        Habilidades habilidades = habilidadesService.getOne(id).get();
        return new ResponseEntity(habilidades, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody HabilidadesDTO habilidadesdto) {
        if (StringUtils.isBlank(habilidadesdto.getNombre())) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        if (habilidadesService.existsByNombre(habilidadesdto.getNombre())) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        Habilidades habilidades = new Habilidades(habilidadesdto.getNombre(),
                habilidadesdto.getPorcentaje());
        habilidadesService.save(habilidades);

        return new ResponseEntity("Habilidad Agregada", HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody HabilidadesDTO habilidadesdto) {
        //Validaciones si existe el ID
        if (!habilidadesService.existsById(id)) {
            return new ResponseEntity("Id no existe", HttpStatus.BAD_REQUEST);
        }
        //Nombre ya existente
        if (habilidadesService.existsByNombre(habilidadesdto.getNombre())
                && habilidadesService.getByNombre(habilidadesdto.getNombre())
                        .get().getId() != id) {
            return new ResponseEntity("Habilidad existente", HttpStatus.BAD_REQUEST);
        }
        //No vacio
        if (StringUtils.isBlank(habilidadesdto.getNombre())) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        Habilidades habilidades = habilidadesService.getOne(id).get();

        habilidades.setNombre(habilidadesdto.getNombre());
        habilidades.setPorcentaje(habilidadesdto.getPorcentaje());

        habilidadesService.save(habilidades);
        return new ResponseEntity("Habilidad actualizada.",HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!habilidadesService.existsById(id)) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        habilidadesService.delete(id);

        return new ResponseEntity("Habilidad eliminada", HttpStatus.OK);
    }

}
