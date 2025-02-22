package c3.examen.Examen.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import c3.examen.Examen.entities.Espacio;

import c3.examen.Examen.repositories.EspacioRepository;

@Service
public class EspacioService {
    private final EspacioRepository espacioRepository;

    public EspacioService(EspacioRepository espacioRepository) {
        this.espacioRepository = espacioRepository;
    }


    public List<Espacio> getAllEspacios() {
        return espacioRepository.findAll();
    }

    public Optional<Espacio> getUserById(int id) {
        return espacioRepository.findById(id);
    }

    public Espacio updateEspacio(int id, String nombre, String tipo, int capacidad_maxima, String disponibilidad){
        Optional<Espacio> optionalEspacio = espacioRepository.findById(id);
        Espacio Space = optionalEspacio.get();
        Space.setNombre(nombre);
        Space.setTipo(tipo);
        Space.setCapacidad_maxima(capacidad_maxima);
        Space.setDisponibilidad(disponibilidad);

        return espacioRepository.save(Space); 
    }
   

    public void deleteEspacio(Integer id) {
        espacioRepository.deleteById(id);
    }
}