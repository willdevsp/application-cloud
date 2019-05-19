package br.com.birocredito.birocredito.dto;

import java.util.Date;

public class DividaNegativarDTO {

    private double valorDivida;
    private String motivoInadiplencia;
    private String nomeEmpresa;
    private String cnpjEmpresa;


    public double getValorDivida() {
        return valorDivida;
    }

    public void setValorDivida(double valorDivida) {
        this.valorDivida = valorDivida;
    }

    public String getMotivoInadiplencia() {
        return motivoInadiplencia;
    }

    public void setMotivoInadiplencia(String motivoInadiplencia) {
        this.motivoInadiplencia = motivoInadiplencia;
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public String getCnpjEmpresa() {
        return cnpjEmpresa;
    }

    public void setCnpjEmpresa(String cnpjEmpresa) {
        this.cnpjEmpresa = cnpjEmpresa;
    }
}
