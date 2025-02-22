package c3.examen.Examen.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import c3.examen.Examen.entities.espacio;
import c3.examen.Examen.repositories.EspacioRepository;

import java.util.List;

@RestController
@RequestMapping("/api/espacios")
public class EspacioController {

    private final EspacioRepository espacioRepository;

    public EspacioController(EspacioRepository espacioRepository){
        this.espacioRepository = espacioRepository;
    }

    @PostMapping("/post")
    public espacio addEspacio(@RequestBody espacio space) {
        return espacioRepository.save(space);
    }

    @GetMapping("/{id}")
    public espacio getEspacio(@PathVariable int id) {
        return espacioRepository.findById(id).orElse(null);
    }

    @GetMapping
    public List<espacio> getAllEspacios() {
        return (List<espacio>) espacioRepository.findAll();
    }

    @PutMapping("/{id}")
    public espacio updateeEspacio(@PathVariable int id, @RequestBody espacio space) {
        return espacioRepository.findById(id).map(e ->{
            e.setNombre(space.getNombre());
            e.setTipo(space.getTipo());
            e.setCapacidad_maxima(space.getCapacidad_maxima());
            e.setDisponibilidad(space.getDisponibilidad());
            return espacioRepository.save(e);
        }).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deleteEspacio(@PathVariable int id) {
        espacioRepository.deleteById(id);
    }

}

