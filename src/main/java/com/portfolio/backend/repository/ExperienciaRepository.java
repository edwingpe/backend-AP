
package com.portfolio.backend.repository;

import com.portfolio.backend.models.Experiencia;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author edwin
 */
@Repository
public interface ExperienciaRepository extends JpaRepository <Experiencia, Integer> {
    
    public Optional<Experiencia> findByNombreExperiencia(String nombreExperiencia);
    
    public boolean existsByNombreExperiencia(String nombreExperiencia);
    
}
