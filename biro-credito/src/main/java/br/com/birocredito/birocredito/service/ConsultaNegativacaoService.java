package br.com.birocredito.birocredito.service;

import br.com.birocredito.birocredito.enuns.OrgaoProtecaoCredito;
import br.com.birocredito.birocredito.model.PessoaFisica;
import br.com.birocredito.birocredito.util.ConsultaNegativacaoInterface;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ConsultaNegativacaoService implements ConsultaNegativacaoInterface {
    @Value("${spc.pessoa.fisica.url}")
    private String spcPf;

    @Override
    public PessoaFisica consultaNegativacaoPF(String cpf, OrgaoProtecaoCredito orgaoProtecaoCredito) {
        String url = null;
        if(orgaoProtecaoCredito.equals(OrgaoProtecaoCredito.SPC))
            url = spcPf;
        if(orgaoProtecaoCredito.equals(orgaoProtecaoCredito.SERASA))
            url = spcPf;
        if(orgaoProtecaoCredito.equals(orgaoProtecaoCredito.BOA_VISTA))
            url = spcPf;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<PessoaFisica>> response = restTemplate.exchange(url+"?search="+cpf, HttpMethod.GET,
                null, new ParameterizedTypeReference<List<PessoaFisica>>(){});
        List<PessoaFisica> pf = response.getBody();
        return pf.get(0);
    }

    private PessoaFisica convertJsonToObject(String json){
        Gson gson = new Gson();
        PessoaFisica obj= gson.fromJson(json,PessoaFisica.class);
        return obj;
    }

    @Override
    public PessoaFisica consultaSPC(String cpf) {
        return consultaNegativacaoPF(cpf, OrgaoProtecaoCredito.SPC);
    }

    @Override
    public PessoaFisica consultaSerasa(String cpf) {
        return consultaNegativacaoPF(cpf, OrgaoProtecaoCredito.SERASA);
    }

    @Override
    public PessoaFisica consultaBoaVista(String cpf) {
        return consultaNegativacaoPF(cpf, OrgaoProtecaoCredito.BOA_VISTA);
    }
}
