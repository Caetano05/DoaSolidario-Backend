package project.doa.solidario.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.doa.solidario.modals.Pessoa;

import java.util.List;
//buscar pessoa digitando o cpf
@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    Pessoa findByCpf(String cpf);
}
