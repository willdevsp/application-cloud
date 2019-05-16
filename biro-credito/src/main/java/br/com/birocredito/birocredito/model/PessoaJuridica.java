package br.com.birocredito.birocredito.model;

import javax.persistence.*;

@Entity
public class PessoaJuridica {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne
    private Endereco enderecoComercial;
    @OneToOne
    private Contato contato;
}
