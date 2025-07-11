package project.doa.solidario.modals;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import project.doa.solidario.modals.enums.PerfilAcesso;

import javax.xml.crypto.Data;
import java.time.LocalDate;

@Entity
public class Usuario extends EntityId{

    //ATRIBUTOS
    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private Long cpf;

    @Column(nullable = false)
    private LocalDate dataNascimento;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String senha;

    //ENUM
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PerfilAcesso perfilAcesso;

    //GET AND SET
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

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public PerfilAcesso getPerfilAcesso() {
        return perfilAcesso;
    }

    public void setPerfilAcesso(PerfilAcesso perfilAcesso) {
        this.perfilAcesso = perfilAcesso;
    }

    //TOSTRING
    @Override
    public String toString() {
        return "Usuario{" +
                "nome='" + nome + '\'' +
                ", cpf=" + cpf +
                ", dataNascimento=" + dataNascimento +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", perfilAcesso=" + perfilAcesso +
                '}';
    }
}
