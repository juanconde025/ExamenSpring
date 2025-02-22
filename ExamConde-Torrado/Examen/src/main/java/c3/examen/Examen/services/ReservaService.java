package c3.examen.Examen.services;

import java.util.List;

import c3.examen.Examen.entities.reserva;
import c3.examen.Examen.repositories.ReservaRepository;

public class ReservaService {
    private ReservaRepository reservaRepository;

    public ReservaService(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }
    
    public List<reserva> getAllReservas(){
        return reservaRepository.findAll();
    }
    

}
