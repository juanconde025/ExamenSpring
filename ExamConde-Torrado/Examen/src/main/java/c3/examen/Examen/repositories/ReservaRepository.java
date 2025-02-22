package c3.examen.Examen.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import c3.examen.Examen.entities.reserva;

public interface ReservaRepository extends JpaRepository<reserva, Integer> {
    List<reserva> findByEstado(String estado);
}
