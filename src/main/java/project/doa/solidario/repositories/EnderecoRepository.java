package project.doa.solidario.repositories;

import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.doa.solidario.modals.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {


}
