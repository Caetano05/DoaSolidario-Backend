package project.doa.solidario.modals;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import project.doa.solidario.modals.enums.Categoria;

@Entity
public class SubCategoria extends EntityId{

    //ATRIBUTOS
    @Column(nullable = false)
    private String descricao;

    //ENUM
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Categoria categoria;

   // GET AND SET
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    // TOSTRING
    @Override
    public String toString() {
        return "SubCategoria{" +
                "descricao='" + descricao + '\'' +
                ", categoria=" + categoria +
                '}';
    }
}
