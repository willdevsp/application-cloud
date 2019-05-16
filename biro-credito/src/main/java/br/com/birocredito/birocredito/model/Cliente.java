package br.com.birocredito.birocredito.model;

import javax.persistence.*;

@Entity
public class Cliente {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne
    private PessoaFisica pessoaFisica;
    @OneToOne
    private PessoaJuridica pessoaJuridica;

    private Long score;
    private String situacaoCadastral;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PessoaFisica getPessoaFisica() {
        return pessoaFisica;
    }

    public void setPessoaFisica(PessoaFisica pessoaFisica) {
        this.pessoaFisica = pessoaFisica;
    }

    public PessoaJuridica getPessoaJuridica() {
        return pessoaJuridica;
    }

    public void setPessoaJuridica(PessoaJuridica pessoaJuridica) {
        this.pessoaJuridica = pessoaJuridica;
    }


    public Long getScore() {
        return score;
    }

    public void setScore(Long score) {
        this.score = score;
    }

    public String getSituacaoCadastral() {
        return situacaoCadastral;
    }

    public void setSituacaoCadastral(String situacaoCadastral) {
        this.situacaoCadastral = situacaoCadastral;
    }
}
