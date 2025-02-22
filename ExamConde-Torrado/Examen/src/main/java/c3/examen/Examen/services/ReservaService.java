package c3.examen.Examen.services;

import java.util.List;

import c3.examen.Examen.entities.Reserva;

import c3.examen.Examen.repositories.ReservaRepository;

public class ReservaService {
    private ReservaRepository reservaRepository;

    public ReservaService(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }
    
    public List<Reserva> getAllReservas(){
        return reservaRepository.findAll();
    }
    

}
