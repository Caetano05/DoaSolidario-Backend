package project.doa.solidario.modals;

import jakarta.persistence.*;
import project.doa.solidario.modals.enums.Estado;
@Entity
public class Endereco extends EntityId{

    @Column(nullable = false)
    private String cidade;

    @Column(nullable = true)
    private String cep;

    @Column(nullable = false)
    private String rua;

    @Column(nullable = true)
    private Long numero;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Estado estado;

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }


    @Override
    public String toString() {
        return "Endereco{" +
                "cidade='" + cidade + '\'' +
                ", cep=" + cep +
                ", rua='" + rua + '\'' +
                ", numero=" + numero +
                ", estado=" + estado +
                '}';
    }
}
