package c3.examen.Examen.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import c3.examen.Examen.entities.espacio;
import java.util.List;


@Repository
public interface EspacioRepository extends JpaRepository<espacio,Integer>{
    Optional<espacio> findByNombre(String nombre);
    Optional<espacio> deleOptional(String nombre);
}
