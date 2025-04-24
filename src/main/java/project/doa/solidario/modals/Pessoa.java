package project.doa.solidario.modals;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Pessoa extends EntityId{

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private Long cpf;

    @Column(nullable = false)
    private String email;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", cpf=" + cpf +
                ", email='" + email + '\'' +
                '}';
    }
}
