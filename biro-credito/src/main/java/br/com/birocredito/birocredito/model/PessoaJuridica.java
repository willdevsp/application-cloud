package br.com.birocredito.birocredito.model;

import javax.persistence.*;
import java.util.List;


@Entity
public class PessoaJuridica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String razaoSocial;
    private String cnpj;

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Endereco enderecoComercial;

    @OneToOne
    private Contato contato;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "pessoa_juridica_dividas",
            joinColumns={@JoinColumn(name = "pessoa_juridica_id", referencedColumnName="id")},
            inverseJoinColumns={@JoinColumn(name="divida_id",   referencedColumnName="id")})
    private List<Divida> dividas;

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private  SituacaoCadastral situacaoCadastral;

    public SituacaoCadastral getSituacaoCadastral() {
        return situacaoCadastral;
    }

    public void setSituacaoCadastral(SituacaoCadastral situacaoCadastral) {
        this.situacaoCadastral = situacaoCadastral;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Endereco getEnderecoComercial() {
        return enderecoComercial;
    }

    public void setEnderecoComercial(Endereco enderecoComercial) {
        this.enderecoComercial = enderecoComercial;
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

    public List<Divida> getDividas() {
        return dividas;
    }

    public void setDividas(List<Divida> dividas) {
        this.dividas = dividas;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
