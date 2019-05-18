package br.com.birocredito.birocredito.service;

import br.com.birocredito.birocredito.model.PessoaJuridica;
import br.com.birocredito.birocredito.model.SituacaoCadastral;
import br.com.birocredito.birocredito.util.NegativacaoInterface;
import org.springframework.stereotype.Service;

@Service
public class NegativacaoService implements NegativacaoInterface {

    @Override
    public void negativarClientePF(PessoaJuridica cnpj) {

    }
}
