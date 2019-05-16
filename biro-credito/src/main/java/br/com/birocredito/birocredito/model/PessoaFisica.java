package br.com.birocredito.birocredito.model;

import javax.persistence.*;

@Entity
public class PessoaFisica {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nomeCompleto;
    private String cpf;
    private String rg;
    @OneToOne
    private Endereco endereco;
    @OneToOne
    private Contato contato;

}
