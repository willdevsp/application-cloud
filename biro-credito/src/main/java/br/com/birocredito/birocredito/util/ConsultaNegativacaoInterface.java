package br.com.birocredito.birocredito.util;

import br.com.birocredito.birocredito.enuns.OrgaoProtecaoCredito;
import br.com.birocredito.birocredito.model.PessoaFisica;

public interface ConsultaNegativacaoInterface {
    PessoaFisica consultaNegativacaoPF(String cpf, OrgaoProtecaoCredito orgaoProtecaoCredito);
    PessoaFisica consultaSpcPF(String cpf);
    PessoaFisica consultaSerasaPF(String cpf);
    PessoaFisica consultaBoaVistaPF(String cpf);
}
