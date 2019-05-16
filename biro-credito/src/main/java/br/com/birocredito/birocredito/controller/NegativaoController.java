package br.com.birocredito.birocredito.controller;

import br.com.birocredito.birocredito.model.Cliente;
import br.com.birocredito.birocredito.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("negativacao")
public class NegativaoController {
    @Autowired
    ClienteRepository repository;
    @PostMapping
    public Cliente addCliente(Cliente cliente){
        return repository.save(cliente);
    }
}
