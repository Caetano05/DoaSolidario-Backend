package project.doa.solidario.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.doa.solidario.modals.Endereco;
import project.doa.solidario.repositories.EnderecoRepository;


import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {
    @Autowired
    private EnderecoRepository repositorioEndereco;

    //SALVA
    public Endereco salvar(Endereco entity){
        return repositorioEndereco.save(entity);
    }

    //LISTAGEM
    public List<Endereco> listarTodos(){
        return repositorioEndereco.findAll();
    }

    //LISTA
    public Endereco listarPorId(Long id){
        return repositorioEndereco.findById(id).orElse(null);
    }

    //ALTERAR
    public Endereco alterarEndereco(Long id, Endereco EnderecoAlterado) {
        Optional<Endereco> encontrado = repositorioEndereco.findById(id);
        if (encontrado.isPresent()) {
            Endereco endereco = encontrado.get();
           endereco.setRua(EnderecoAlterado.getRua());
           endereco.setCidade(EnderecoAlterado.getCidade());
           endereco.setEstado(EnderecoAlterado.getEstado());
           endereco.setCep(EnderecoAlterado.getCep());
           endereco.setNumero(EnderecoAlterado.getNumero());
            return repositorioEndereco.save(endereco);
        }

        return null;
    }

    //DELETAR
    public void deletar(Long id){
        repositorioEndereco.deleteById(id);
    }
}
