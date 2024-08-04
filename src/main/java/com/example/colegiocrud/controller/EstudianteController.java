package com.example.colegiocrud.controller;

import com.example.colegiocrud.model.Estudiante;
import com.example.colegiocrud.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estudiantes")
public class EstudianteController {

    @Autowired
    private EstudianteService estudianteService;

    @GetMapping
    public List<Estudiante> getAllEstudiantes() {
        return estudianteService.getAllEstudiantes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estudiante> getEstudianteById(@PathVariable int id) {
        return estudianteService.getEstudianteById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Estudiante addEstudiante(@RequestBody Estudiante estudiante) {
        return estudianteService.addEstudiante(estudiante);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Estudiante> updateEstudiante(@PathVariable int id, @RequestBody Estudiante estudiante) {
        return estudianteService.getEstudianteById(id)
                .map(existingEstudiante -> {
                    estudiante.setId(existingEstudiante.getId());
                    return ResponseEntity.ok(estudianteService.updateEstudiante(estudiante));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEstudiante(@PathVariable int id) {
        estudianteService.deleteEstudiante(id);
        return ResponseEntity.noContent().build();
    }
}
