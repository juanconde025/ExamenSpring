package c3.examen.Examen.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import c3.examen.Examen.entities.espacio;

@EnableJpaRepositories
@Repository
public interface EspacioRepository extends JpaRepository<espacio,Integer>{
    Optional<espacio> findByNombre(String nombre);
    Optional<espacio> deleOptional(String nombre);
}
