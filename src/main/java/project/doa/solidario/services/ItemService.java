package project.doa.solidario.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.doa.solidario.modals.Item;
import project.doa.solidario.repositories.ItemRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {
    @Autowired
    private ItemRepository repositorioItem;

    //SALVA O ITEM
    public Item salvar(Item entity){
        return repositorioItem.save(entity);
    }

    //LISTAGEM DOS ITENS
    public List<Item> buscaTodos() {
        return repositorioItem.findAll();
    }

    //LISTA ITEM POR ID
    public Item buscarPorId(Long id){
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
            return repositorioItem.save(item);
        }

        return null;
    }

    //DELETAR O ITEM
    public void deletar(Long id){
            repositorioItem.deleteById(id);
        }
}
