package c3.examen.Examen.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import c3.examen.Examen.entities.Reserva;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
@EnableJpaRepositories
@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Integer> {
    List<Reserva> findByEstado(String estado);
}
