
package com.portfolio.backend.repository;

import com.portfolio.backend.models.Habilidades;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author edwin
 */
public interface HabilidadesRepository extends JpaRepository<Habilidades, Integer> {
    Optional<Habilidades> findByNombre(String nombre);
    public boolean existsByNombre(String nombre);
}
