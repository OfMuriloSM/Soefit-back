package br.edu.ifce.soefit.service;

import br.edu.ifce.soefit.dto.FichaTreinoDTO;
import br.edu.ifce.soefit.model.FichaTreino;
import br.edu.ifce.soefit.model.Usuario;
import br.edu.ifce.soefit.repository.FichaTreinoRepository;
import br.edu.ifce.soefit.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class FichaTreinoService {

    private final FichaTreinoRepository fichaRepository;
    private final UsuarioRepository usuarioRepository;

    public FichaTreinoService(FichaTreinoRepository fichaRepository, UsuarioRepository usuarioRepository) {
        this.fichaRepository = fichaRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public List<FichaTreino> listarTodas() { return fichaRepository.findAll(); }

    public Optional<FichaTreino> buscarPorId(Long id) { return fichaRepository.findById(id); }

    public FichaTreino salvarComDTO(FichaTreinoDTO dto) {
        Usuario usuario = usuarioRepository.findById(dto.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado. Crie o usuário antes de associar uma ficha."));

        FichaTreino ficha = new FichaTreino();
        ficha.setNomeTreino(dto.getNomeTreino());
        ficha.setUsuario(usuario);

        return fichaRepository.save(ficha);
    }

    public void deletar(Long id) { fichaRepository.deleteById(id); }
}