package br.com.birocredito.birocredito.service;

import br.com.birocredito.birocredito.dto.PessoaFisicaNegativarDTO;
import br.com.birocredito.birocredito.model.PessoaFisica;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


@Service
public class ValidatorPessoaFisica implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return PessoaFisica.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        PessoaFisicaNegativarDTO pessoaFisica = (PessoaFisicaNegativarDTO   ) target;
        if(validarCpfVazio(pessoaFisica.getCpf())){
         errors.rejectValue("cpf", "cpf.empty");
        }


    }

    public boolean validarCpfVazio(String cpf){
        return cpf == null || cpf.isEmpty();
    }
}
