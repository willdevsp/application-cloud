package br.com.birocredito.birocredito.service;

import br.com.birocredito.birocredito.model.PessoaFisica;
import org.hibernate.validator.constraints.br.CNPJ;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


@Service
public class ValidatorPessoaFisica implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return PessoaFisica.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        PessoaFisica pessoaFisica = (PessoaFisica) target;
        if(validarCpfVazio(pessoaFisica.getCpf())){
         errors.rejectValue("cpf", "invalid.cpf");
        }


    }

    public boolean validarCpfVazio(String cpf){
        return cpf == null || cpf.isEmpty();
    }
}
