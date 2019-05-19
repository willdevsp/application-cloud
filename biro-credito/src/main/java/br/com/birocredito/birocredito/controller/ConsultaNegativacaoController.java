package br.com.birocredito.birocredito.controller;

import br.com.birocredito.birocredito.model.PessoaFisica;
import br.com.birocredito.birocredito.service.ConsultaNegativacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("consulta")
public class ConsultaNegativacaoController {
    @Autowired
    ConsultaNegativacaoService service;

    @GetMapping
    public ResponseEntity<?> consultarNegativacao(@PathParam("cpf") String cpf){

        try{
            List<PessoaFisica> pf = service.consultaCpf(cpf);
           return ResponseEntity.ok().body(pf);

        }catch (Exception e){

        }
        return null;
    }
}
