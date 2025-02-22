package c3.examen.Examen.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import c3.examen.Examen.entities.Espacio;


@Repository
public interface EspacioRepository extends JpaRepository<Espacio, Integer> {
    Optional<Espacio> findById(Integer id);
}
