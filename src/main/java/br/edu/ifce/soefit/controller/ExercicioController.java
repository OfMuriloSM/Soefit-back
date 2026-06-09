package br.edu.ifce.soefit.controller;

import br.edu.ifce.soefit.dto.ExercicioDTO;
import br.edu.ifce.soefit.model.Exercicio;
import br.edu.ifce.soefit.service.ExercicioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/exercicios")
@CrossOrigin(origins = "*")
public class ExercicioController {

    private final ExercicioService service;

    public ExercicioController(ExercicioService service) { this.service = service; }

    @GetMapping
    public ResponseEntity<List<Exercicio>> listar() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @PostMapping
    public ResponseEntity<Exercicio> criar(@Valid @RequestBody ExercicioDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.salvarComDTO(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Exercicio> atualizar(@PathVariable Long id, @Valid @RequestBody ExercicioDTO dto) {
        return ResponseEntity.ok(service.atualizar(id, dto));
    }
}