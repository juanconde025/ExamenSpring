package c3.examen.Examen.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import c3.examen.Examen.entities.espacio;

@Repository
public interface EspacioRepository extends JpaRepository<espacio,Integer>{
    List<espacio> findByNombre(String nombre);
}
