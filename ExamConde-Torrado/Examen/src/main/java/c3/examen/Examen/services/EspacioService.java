package c3.examen.Examen.services;

import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import c3.examen.Examen.entities.espacio;
import c3.examen.Examen.repositories.EspacioRepository;

@Service
public class EspacioService {
    private EspacioRepository espacioRepository;

    public EspacioService() {
        this.espacioRepository = espacioRepository;
    }

    public List<espacio> getAllEspacios() {
        return espacioRepository.findAll();
    }

    public List<espacio> getUserByName(String nombre) {
        return espacioRepository.findByNombre(nombre);
    }


    public espacio updateEspacio(String nombre, espacio updatedEspacio) {
        return espacioRepository.findByNombre(nombre).map(espace -> {
            espace.setNombre(updatedEspacio.getNombre());
            espace.setTipo(updatedEspacio.getTipo());
            espace.setCapacidad_maxima(updatedEspacio.getCapacidad_maxima());
            espace.setDisponibilidad(updatedEspacio.getDisponibilidad());

            return userRepository.save(user);
        }).orElseThrow(() -> new RuntimeException("Espacio with name " + nombre + " not exist"));
    }

    public void deleteEspacio(String nombre) {
        return espacioRepository.deleOptional();
    }
}
