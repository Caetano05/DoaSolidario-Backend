package project.doa.solidario.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.doa.solidario.modals.Pessoa;
import project.doa.solidario.repositories.PessoaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {
    @Autowired
    private PessoaRepository repositorioPessoa;

    //SALVAR
    public Pessoa salvar(Pessoa entity){
        return repositorioPessoa.save(entity);
    }

    //LISTAGEM
    public List<Pessoa> listarTodos(){
        return repositorioPessoa.findAll();
    }

    //LISTAR
    public Pessoa listarPorId(Long id){
        return repositorioPessoa.findById(id).orElse(null);
    }

    //ALTERAR
    public Pessoa alterarPessoa(Long id, Pessoa PessoaAlterado) {
        Optional<Pessoa> encontrado = repositorioPessoa.findById(id);
        if (encontrado.isPresent()) {
            Pessoa pessoa = encontrado.get();
            pessoa.setNome(PessoaAlterado.getNome());
            pessoa.setCpf(PessoaAlterado.getCpf());
            pessoa.setEmail(PessoaAlterado.getEmail());
            return repositorioPessoa.save(pessoa);
        }

        return null;
    }
    //DELETAR
    public void deletar(Long id){
        repositorioPessoa.deleteById(id);
    }


}
