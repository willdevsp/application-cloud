package br.com.birocredito.birocredito.util;

import br.com.birocredito.birocredito.model.PessoaJuridica;
import br.com.birocredito.birocredito.model.SituacaoCadastral;

public interface NegativacaoInterface {
    void negativarClientePF(PessoaJuridica cnpj);

}
