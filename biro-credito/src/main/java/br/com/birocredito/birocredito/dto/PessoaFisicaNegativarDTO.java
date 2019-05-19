package br.com.birocredito.birocredito.dto;

import java.util.List;

public class PessoaFisicaNegativarDTO {

    private String cpf;
    private List<DividaNegativarDTO> dividas;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public List<DividaNegativarDTO> getDividas() {
        return dividas;
    }

    public void setDividas(List<DividaNegativarDTO> dividas) {
        this.dividas = dividas;
    }
}
