package br.edu.ifce.soefit.service;

import br.edu.ifce.soefit.model.Usuario;
import br.edu.ifce.soefit.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) { this.repository = repository; }

    public List<Usuario> listarTodos() { return repository.findAll(); }

    public Optional<Usuario> buscarPorId(Long id) { return repository.findById(id); }

    public Usuario salvar(Usuario usuario) { return repository.save(usuario); }

    public void deletar(Long id) { repository.deleteById(id); }
    
    public Optional<Usuario> autenticar(String email, String senha) {
        return repository.findByEmailAndSenha(email, senha);
    }
}