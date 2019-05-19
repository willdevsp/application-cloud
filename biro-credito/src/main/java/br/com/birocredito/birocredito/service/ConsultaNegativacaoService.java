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

import java.util.ArrayList;
import java.util.List;

@Service
public class ConsultaNegativacaoService implements ConsultaNegativacaoInterface {
    @Value("${spc.pessoa.fisica.url}")
    private String spcPf;
    @Value("${serasa.pessoa.fisica.url}")
    private String serasaPf;
    @Value("${boavista.pessoa.fisica.url}")
    private String boavistaPf;

    @Override
    public PessoaFisica consultaNegativacaoPF(String cpf, OrgaoProtecaoCredito orgaoProtecaoCredito) {
        String url = null;
        if(orgaoProtecaoCredito.equals(OrgaoProtecaoCredito.SPC))
            url = spcPf;
        if(orgaoProtecaoCredito.equals(orgaoProtecaoCredito.SERASA))
            url = serasaPf;
        if(orgaoProtecaoCredito.equals(orgaoProtecaoCredito.BOA_VISTA))
            url = boavistaPf;
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
    public PessoaFisica consultaSpcPF(String cpf) {
        return consultaNegativacaoPF(cpf, OrgaoProtecaoCredito.SPC);
    }

    @Override
    public PessoaFisica consultaSerasaPF(String cpf) {
        return consultaNegativacaoPF(cpf, OrgaoProtecaoCredito.SERASA);
    }

    @Override
    public PessoaFisica consultaBoaVistaPF(String cpf) {
        return consultaNegativacaoPF(cpf, OrgaoProtecaoCredito.BOA_VISTA);
    }
    public List<PessoaFisica> consultaCpf(String cpf){
        List<PessoaFisica> listPessoaFisica = new ArrayList<>();
        PessoaFisica spc = consultaSpcPF(cpf);
        PessoaFisica serasa = consultaSerasaPF(cpf);
        PessoaFisica boaVista = consultaBoaVistaPF(cpf);
        if(spc!= null)
            listPessoaFisica.add(spc);
        if(serasa != null)
            listPessoaFisica.add(serasa);
        if(boaVista!=null)
            listPessoaFisica.add(boaVista);
        return listPessoaFisica;
    }
}
