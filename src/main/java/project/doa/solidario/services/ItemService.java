package project.doa.solidario.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.doa.solidario.modals.Endereco;
import project.doa.solidario.modals.Item;
import project.doa.solidario.modals.Pessoa;
import project.doa.solidario.modals.enums.Categoria;
import project.doa.solidario.modals.enums.Situacao;
import project.doa.solidario.repositories.EnderecoRepository;
import project.doa.solidario.repositories.ItemRepository;
import project.doa.solidario.repositories.PessoaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {
    @Autowired
    private ItemRepository repositorioItem;

    @Autowired
    private PessoaRepository repositorioPessoa;

    @Autowired
    private EnderecoRepository repositorioEndereco;

    //SALVA O ITEM
    public Item salvar(Item entity) {
        if (entity.getPessoadoador() != null) {
            Pessoa pessoa = entity.getPessoadoador();

            if (pessoa.getEndereco() != null && pessoa.getEndereco().getId() == null) {
                Endereco enderecoSalvo = repositorioEndereco.save(pessoa.getEndereco());
                pessoa.setEndereco(enderecoSalvo);
            }

            if (pessoa.getCpf() == null) {
                pessoa = repositorioPessoa.save(pessoa);
                entity.setPessoadoador(pessoa);
            }
        }

        return repositorioItem.save(entity);
    }

    //LISTAGEM DOS ITENS
    public List<Item> listarTodos(Categoria categoria, Situacao situacao) {
        if (categoria != null) {
            return repositorioItem.findByCategoria(categoria);
        } else if (situacao != null) {
            return repositorioItem.findBySituacao(situacao);
        } else {
            return repositorioItem.findAll();
        }
    }

    //LISTA ITEM POR ID
    public Item listarPorId(Long id){
        return repositorioItem.findById(id).orElse(null);
    }

    //ALTERAR ITEM
    public Item alterarItem(Long id, Item ItemAlterado) {
        Optional<Item> encontrado = repositorioItem.findById(id);
        if (encontrado.isPresent()) {
            Item item = encontrado.get();
            item.setDescricao(ItemAlterado.getDescricao());
            item.setData_cadastro(ItemAlterado.getData_cadastro());
            item.setQuantidade(ItemAlterado.getQuantidade());
            item.setValor(ItemAlterado.getValor());
            item.setCaminhao(ItemAlterado.getCaminhao());
            item.setAnexo(ItemAlterado.getAnexo());
            item.setCategoria(ItemAlterado.getCategoria());
            item.setEstadoConservacao(ItemAlterado.getEstadoConservacao());
            item.setSituacao(ItemAlterado.getSituacao());
            item.setSubCategoria(ItemAlterado.getSubCategoria());
            item.setPessoadoador(ItemAlterado.getPessoadoador());
            item.setPessoabeneficiario(ItemAlterado.getPessoabeneficiario());
            return repositorioItem.save(item);
        }

        return null;
    }

    //DELETAR O ITEM
    public void deletar(Long id){
            repositorioItem.deleteById(id);
        }
}
