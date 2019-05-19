package br.com.birocredito.birocredito.controller;

import br.com.birocredito.birocredito.dto.PessoaFisicaNegativarDTO;
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
    public ResponseEntity<?> consultarPF(@RequestBody PessoaFisicaNegativarDTO pessoaFisicaNegativarDTO, Errors errors){
        validatorPessoaFisica.validate(pessoaFisicaNegativarDTO, errors);

      try{
          if(errors.hasErrors()){
              return ResponseEntity
                      .badRequest()
                      .body(getMessage(errors.getFieldError().getCode()));
          }
          PessoaFisica pf = service.negativarClientePF(pessoaFisicaNegativarDTO);
          if(pf!= null)
            return ResponseEntity.ok().body(pf);
          return ResponseEntity.badRequest().body(getMessage("negativar.error"));

      }catch (Exception e){
          System.out.println(e);
      }
        return null;
    }

    private String getMessage(String code){
        return messageSource.getMessage(code, null,null);
    }
}
