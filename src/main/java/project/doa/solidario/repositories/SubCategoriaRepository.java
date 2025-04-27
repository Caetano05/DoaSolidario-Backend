package project.doa.solidario.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.doa.solidario.modals.SubCategoria;

@Repository
public interface SubCategoriaRepository  extends JpaRepository<SubCategoria, Long>{
}
