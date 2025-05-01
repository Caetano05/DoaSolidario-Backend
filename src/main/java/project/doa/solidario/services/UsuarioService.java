package project.doa.solidario.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.doa.solidario.modals.Usuario;
import project.doa.solidario.repositories.UsuarioRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repositorioUsuario;

    //SALVAR O USUARIO
    public Usuario salvar(Usuario entity){
        return  repositorioUsuario.save(entity);
    }

    //LISTAGEM DOS USUARIOS
    public List<Usuario> listarTodos(){
        return repositorioUsuario.findAll();
    }

    //LISTAR POR ID
    public Usuario listarPorId(Long id){
        return repositorioUsuario.findById(id).orElse(null);
    }

    //ALTERAR O USUARIO
    public Usuario alterarUsuario(Long id, Usuario UsuarioAlterado){
        Optional<Usuario> encontrado = repositorioUsuario.findById(id);
        if (encontrado.isPresent()){
            Usuario usuario = encontrado.get();
            usuario.setNome(UsuarioAlterado.getNome());
            usuario.setCpf(UsuarioAlterado.getCpf());
            usuario.setDataNascimento(UsuarioAlterado.getDataNascimento());
            usuario.setEmail(UsuarioAlterado.getEmail());
            usuario.setSenha(UsuarioAlterado.getSenha());
            usuario.setPerfilAcesso(UsuarioAlterado.getPerfilAcesso());
            return repositorioUsuario.save(usuario);
        }
        return null;
    }

    //DELETAR USUARIO
    public void deletar(Long id){
        repositorioUsuario.deleteById(id);
    }

}
