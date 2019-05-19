package br.com.birocredito.birocredito.service;

import br.com.birocredito.birocredito.dto.PessoaFisicaNegativarDTO;
import br.com.birocredito.birocredito.model.PessoaFisica;
import br.com.birocredito.birocredito.model.PessoaJuridica;
import br.com.birocredito.birocredito.model.SituacaoCadastral;
import br.com.birocredito.birocredito.util.NegativacaoInterface;
import jdk.nashorn.internal.objects.annotations.Property;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NegativacaoService implements NegativacaoInterface {
    @Value("${spc.pessoa.fisica.url}")
    private String spcUrl;

    @Override
    public PessoaFisica negativarClientePF(PessoaFisicaNegativarDTO pessoaFisicaNegativarDTO) {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<PessoaFisicaNegativarDTO> request = new HttpEntity<>(pessoaFisicaNegativarDTO);
        PessoaFisica pf = restTemplate.postForObject(spcUrl, request,PessoaFisica.class);
        return pf;
    }
}
