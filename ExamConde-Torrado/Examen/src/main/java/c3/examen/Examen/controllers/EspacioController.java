package c3.examen.Examen.controllers;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import c3.examen.Examen.entities.Espacio;

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
    public Espacio addEspacio(@RequestBody Espacio space) {
        return espacioRepository.save(space);
    }

    @GetMapping("/{id}")
    public Espacio getEspacio(@PathVariable int id) {
        return espacioRepository.findById(id).orElse(null);
    }

    @GetMapping
    public List<Espacio> getAllEspacios() {
        return (List<Espacio>) espacioRepository.findAll();
    }

    @PutMapping("/{id}")
    public Espacio updateeEspacio(@PathVariable int id, @RequestBody Espacio space) {
        return espacioRepository.findById(id).map(e ->{
            e.setNombre(space.getNombre());
            e.setTipo(space.getTipo());
            e.setCapacidad_maxima(space.getCapacidad_maxima());
            e.setDisponibilidad(space.getDisponibilidad());
            return espacioRepository.save(e);
        }).orElse(null);
    }

    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEspacio(@PathVariable int id) {
        if (espacioRepository.existsById(id)) {
            espacioRepository.deleteById(id);
            return ResponseEntity.ok("Espacio eliminado correctamente.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Espacio no encontrado.");
        }
    }

}

