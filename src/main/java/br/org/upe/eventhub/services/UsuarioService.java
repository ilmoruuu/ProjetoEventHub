package br.org.upe.eventhub.services;

import br.org.upe.eventhub.entities.Usuario;

import java.util.List;

public interface UsuarioService {

    public Usuario cadastrarUsuario(Usuario usuario);
    public Usuario atualizarUsuario(Usuario usuario);
    public void removerUsuario(int id);
    public List<Usuario> listarUsuarios();
    public Usuario buscarUsuarioPorId(Integer id);
    public Usuario buscarUsuarioPorEmailESenha(String email, String senha);
    public Usuario buscarUsuarioPorEmail(String email);
    public Usuario buscarUsarioPorLoginESenha(String login, String senha);

}
