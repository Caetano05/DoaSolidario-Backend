package project.doa.solidario.modals;

import jakarta.persistence.*;
import project.doa.solidario.modals.enums.Categoria;
import project.doa.solidario.modals.enums.EstadoConservacao;
import project.doa.solidario.modals.enums.Situacao;

import java.time.LocalDate;


@Entity
public class Item extends EntityId{

    // ATRIBUTOS
    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private LocalDate data_cadastro;

    @Column(nullable = false)
    private Long quantidade;

    @Column(nullable = true)
    private Double valor;

    @Column()
    private Boolean caminhao;

    @Column()
    private String anexo;


    // ENUMS
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Categoria categoria;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoConservacao estadoConservacao;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Situacao situacao;

    //INTEGRAÇÃO
    @ManyToOne
    @JoinColumn(nullable = false)
    private SubCategoria subCategoria;

    //PESSOA EM CACHE E SALVA JUNTO
    @ManyToOne //(cascade = CascadeType.ALL)
    @JoinColumn(name = "pessoa_doador")
    private Pessoa pessoadoador;

    //DUAS PESSOAS
    @ManyToOne //(cascade = CascadeType.ALL)
    @JoinColumn(name = "pessoa_beneficiario")
    private Pessoa pessoabeneficiario;



    //GET AND SET


    public Pessoa getPessoadoador() {
        return pessoadoador;
    }

    public void setPessoadoador(Pessoa pessoadoador) {
        this.pessoadoador = pessoadoador;
    }

    public Pessoa getPessoabeneficiario() {
        return pessoabeneficiario;
    }

    public void setPessoabeneficiario(Pessoa pessoabeneficiario) {
        this.pessoabeneficiario = pessoabeneficiario;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getData_cadastro() {
        return data_cadastro;
    }

    public void setData_cadastro(LocalDate data_cadastro) {
        this.data_cadastro = data_cadastro;
    }

    public void setSubCategoria(SubCategoria subCategoria) {
        this.subCategoria = subCategoria;
    }

    public Long getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Long quantidade) {
        this.quantidade = quantidade;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Boolean getCaminhao() {
        return caminhao;
    }

    public void setCaminhao(Boolean caminhao) {
        this.caminhao = caminhao;
    }

    public String getAnexo() {
        return anexo;
    }

    public void setAnexo(String anexo) {
        this.anexo = anexo;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public EstadoConservacao getEstadoConservacao() {
        return estadoConservacao;
    }

    public void setEstadoConservacao(EstadoConservacao estadoConservacao) {
        this.estadoConservacao = estadoConservacao;
    }

    public Situacao getSituacao() {
        return situacao;
    }

    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }

    public SubCategoria getSubCategoria() {
        return subCategoria;
    }


    //TOSTRING


    @Override
    public String toString() {
        return "Item{" +
                "descricao='" + descricao + '\'' +
                ", data_cadastro=" + data_cadastro +
                ", quantidade=" + quantidade +
                ", valor=" + valor +
                ", caminhao=" + caminhao +
                ", anexo='" + anexo + '\'' +
                ", categoria=" + categoria +
                ", estadoConservacao=" + estadoConservacao +
                ", situacao=" + situacao +
                ", subCategoria=" + subCategoria +
                ", pessoadoador=" + pessoadoador +
                ", pessoabeneficiario=" + pessoabeneficiario +
                '}';
    }
}
