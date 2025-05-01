package project.doa.solidario.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.doa.solidario.modals.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
