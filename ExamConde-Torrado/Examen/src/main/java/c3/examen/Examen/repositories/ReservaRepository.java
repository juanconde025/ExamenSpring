package c3.examen.Examen.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import c3.examen.Examen.entities.reserva;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
@EnableJpaRepositories
@Repository
public interface ReservaRepository extends JpaRepository<reserva, Integer> {
    List<reserva> findByEstado(String estado);
}
