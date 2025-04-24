package project.doa.solidario.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.doa.solidario.modals.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
}
