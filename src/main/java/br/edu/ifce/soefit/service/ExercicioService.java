package br.edu.ifce.soefit.service;

import br.edu.ifce.soefit.dto.ExercicioDTO;
import br.edu.ifce.soefit.model.Exercicio;
import br.edu.ifce.soefit.model.FichaTreino;
import br.edu.ifce.soefit.repository.ExercicioRepository;
import br.edu.ifce.soefit.repository.FichaTreinoRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ExercicioService {

    private final ExercicioRepository exercicioRepository;
    private final FichaTreinoRepository fichaRepository;

    public ExercicioService(ExercicioRepository exercicioRepository, FichaTreinoRepository fichaRepository) {
        this.exercicioRepository = exercicioRepository;
        this.fichaRepository = fichaRepository;
    }

    public List<Exercicio> listarTodos() { return exercicioRepository.findAll(); }

    public Optional<Exercicio> buscarPorId(Long id) { return exercicioRepository.findById(id); }

    public Exercicio salvarComDTO(ExercicioDTO dto) {
        FichaTreino ficha = fichaRepository.findById(dto.getFichaId())
                .orElseThrow(() -> new RuntimeException("Ficha não encontrada")); // Simples tratamento

        Exercicio exercicio = new Exercicio();
        exercicio.setNome(dto.getNome());
        exercicio.setSeries(dto.getSeries());
        exercicio.setRepeticoes(dto.getRepeticoes());
        exercicio.setCargaKg(dto.getCargaKg());
        exercicio.setFichaTreino(ficha);

        return exercicioRepository.save(exercicio);
    }

    public void deletar(Long id) { exercicioRepository.deleteById(id); }
}