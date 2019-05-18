package br.com.birocredito.birocredito.controller;

import br.com.birocredito.birocredito.model.PessoaFisica;
import br.com.birocredito.birocredito.model.PessoaJuridica;
import br.com.birocredito.birocredito.model.SituacaoCadastral;
import br.com.birocredito.birocredito.repository.PessoaFisicaRepository;
import br.com.birocredito.birocredito.service.NegativacaoService;
import br.com.birocredito.birocredito.service.ValidatorPessoaFisica;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("negativacao")
public class NegativaoController {
    @Autowired
    private PessoaFisicaRepository repository;
    @Autowired
    private NegativacaoService service;

    @Autowired
    private ValidatorPessoaFisica validatorPessoaFisica;

    @Autowired
    private MessageSource messageSource;

    @PostMapping
    public PessoaFisica addCliente(@RequestBody PessoaFisica pf){
        return repository.save(pf);
    }


    @GetMapping("/negativar/pessoajuridica")
    public SituacaoCadastral consultar(PessoaJuridica cnpj, Errors errors){



        return null;
    }

    @PostMapping("/negativar/pessoafisica")
    public ResponseEntity<?> consultarPF(@RequestBody PessoaFisica pessoaFisica, Errors errors){
        validatorPessoaFisica.validate(pessoaFisica, errors);
        if(errors.hasErrors()){
            return ResponseEntity
                    .badRequest()
                    .body(messageSource.getMessage(errors.getFieldError().getCode(),null,null));
        }

        return null;
    }
}
