package br.org.upe.eventhub.services;

import br.org.upe.eventhub.entities.Usuario;
import br.org.upe.eventhub.exceptions.UsuarioExistenteException;
import br.org.upe.eventhub.repositories.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.object.UpdatableSqlQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;


    @Override
    public Usuario cadastrarUsuario(Usuario usuario) {
        Optional<Usuario> usuarioBanco = usuarioRepository.findByEmail(usuario.getEmail());

        if (usuarioBanco.isPresent()) {
            throw new UsuarioExistenteException();
        }

        Optional<Usuario> usuarioBanco2 = usuarioRepository.findByCpf(usuario.getCpf());
        if (usuarioBanco2.isPresent()) {
            return null;
        }

        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario atualizarUsuario(Usuario usuario) {
        Optional<Usuario> usuarioBanco = usuarioRepository.findById(usuario.getId());
        if (usuarioBanco.isPresent()) {
            return usuarioRepository.save(usuario);
        }else {
            return null;
        }
    }

    @Override
    public void removerUsuario(int id) {


    }

    @Override
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario buscarUsuarioPorId(Integer id) {
//        Optional<Usuario> usuario = usuarioRepository.findById(id);
//        return usuario.orElse(null);

        return usuarioRepository.findById(id).orElse(null);
    }

    @Override
    public Usuario buscarUsuarioPorEmailESenha(String email, String senha) {
        return usuarioRepository.findByEmailAndSenha(email, senha).orElse(null);
    }

    @Override
    public Usuario buscarUsuarioPorEmail(String email) {
        return usuarioRepository.findByEmail(email).orElse(null);
    }

    @Override
    public Usuario buscarUsarioPorLoginESenha(String login, String senha) {
        return null;
    }
}
