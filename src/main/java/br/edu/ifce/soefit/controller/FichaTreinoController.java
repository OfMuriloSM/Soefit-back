package br.edu.ifce.soefit.controller;

import br.edu.ifce.soefit.dto.FichaTreinoDTO;
import br.edu.ifce.soefit.model.FichaTreino;
import br.edu.ifce.soefit.service.FichaTreinoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fichas")
@CrossOrigin(origins = "*")
public class FichaTreinoController {

    private final FichaTreinoService service;

    public FichaTreinoController(FichaTreinoService service) { this.service = service; }

    @GetMapping
    public ResponseEntity<List<FichaTreino>> listar() {
        return ResponseEntity.ok(service.listarTodas());
    }

    @PostMapping
    public ResponseEntity<FichaTreino> criar(@Valid @RequestBody FichaTreinoDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.salvarComDTO(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}