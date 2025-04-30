package project.doa.solidario.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.doa.solidario.modals.SubCategoria;
import project.doa.solidario.repositories.SubCategoriaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SubCategoriaService {

    @Autowired
    private SubCategoriaRepository repositorioSubCategoria;

    //SALVAR A SUB CATEGORIA
    public SubCategoria salvar(SubCategoria entity){
        return repositorioSubCategoria.save(entity);
    }

    //LISTAGEM DOS ITENS
    public List<SubCategoria> listarTodos(){
        return repositorioSubCategoria.findAll();
    }

    //LISTAR POR ID
    public SubCategoria listarPorId(Long id){
        return repositorioSubCategoria.findById(id).orElse(null);
    }

    //ALTERAR SUB CATEGORIA
    public  SubCategoria alterarSubCategoria(Long id, SubCategoria SubAlterado) {
        Optional<SubCategoria> encontrado = repositorioSubCategoria.findById(id);
        if (encontrado.isPresent()) {
            SubCategoria subCategoria = encontrado.get();
            subCategoria.setDescricao(SubAlterado.getDescricao());
            subCategoria.setCategoria(SubAlterado.getCategoria());
            return repositorioSubCategoria.save(subCategoria);
        }

        return null;
    }

    //DELETAR A SUB CATEGORIA
    public void deletar(Long id){
        repositorioSubCategoria.deleteById(id);
    }

}
