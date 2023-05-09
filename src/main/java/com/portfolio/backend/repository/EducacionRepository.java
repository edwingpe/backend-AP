
package com.portfolio.backend.repository;

import com.portfolio.backend.models.Educacion;
import com.portfolio.backend.models.Experiencia;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author edwin
 */

@Repository
public interface EducacionRepository extends JpaRepository <Educacion, Integer> {
    
    public Optional<Educacion> findByNombreEducacion(String nombreEducacion);
    
    public boolean existsByNombreEducacion(String nombreEducacion);
}
