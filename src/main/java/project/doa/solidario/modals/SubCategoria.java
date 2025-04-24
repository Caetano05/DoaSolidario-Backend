package project.doa.solidario.modals;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class SubCategoria extends EntityId{

    @Column(nullable = false)
    private String descricao;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "SubCategoria{" +
                "descricao='" + descricao + '\'' +
                '}';
    }
}
