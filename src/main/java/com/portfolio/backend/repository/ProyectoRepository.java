
package com.portfolio.backend.repository;

import com.portfolio.backend.models.Proyecto;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author edwin
 */
@Repository
public interface ProyectoRepository extends JpaRepository<Proyecto, Integer>{
    public Optional<Proyecto> findByNombre(String nombre);
    public boolean existsByNombre(String nombre);
}
