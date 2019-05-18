package br.com.birocredito.birocredito.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;


@Entity
public class PessoaFisica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeCompleto;
    private String cpf;
    private String rg;
    private LocalDate dataNascimento;

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Endereco endereco;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "pessoafisica_contato",
            joinColumns={@JoinColumn(name = "pessoa_fisica_id", referencedColumnName="id")},
            inverseJoinColumns={@JoinColumn(name="contato_id",   referencedColumnName="id")})
    private List<Contato> contatos;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "pessoafisica_dividas",
    joinColumns={@JoinColumn(name = "pessoa_fisica_id", referencedColumnName="id")},
    inverseJoinColumns={@JoinColumn(name="divida_id",   referencedColumnName="id")})
    private List<Divida> dividas;

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private  SituacaoCadastral situacaoCadastral;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }


    public List<Contato> getContatos() {
        return contatos;
    }

    public void setContatos(List<Contato> contatos) {
        this.contatos = contatos;
    }

    public List<Divida> getDividas() {
        return dividas;
    }

    public void setDividas(List<Divida> dividas) {
        this.dividas = dividas;
    }

    public SituacaoCadastral getSituacaoCadastral() {
        return situacaoCadastral;
    }

    public void setSituacaoCadastral(SituacaoCadastral situacaoCadastral) {
        this.situacaoCadastral = situacaoCadastral;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
