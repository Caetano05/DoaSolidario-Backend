package project.doa.solidario.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.doa.solidario.modals.Item;
import project.doa.solidario.modals.enums.Categoria;
import project.doa.solidario.modals.enums.Situacao;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findByCategoria(Categoria categoria);
    List<Item> findBySituacao(Situacao situacao);

}
