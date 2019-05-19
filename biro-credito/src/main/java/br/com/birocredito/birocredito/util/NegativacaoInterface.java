package br.com.birocredito.birocredito.util;

import br.com.birocredito.birocredito.dto.PessoaFisicaNegativarDTO;
import br.com.birocredito.birocredito.model.PessoaFisica;

public interface NegativacaoInterface {
    PessoaFisica negativarClientePF(PessoaFisicaNegativarDTO pessoaFisicaNegativarDTO);

}
