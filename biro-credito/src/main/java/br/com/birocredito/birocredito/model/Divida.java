package br.com.birocredito.birocredito.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Divida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDateTime dataInclusaoDivida;
    private double valorDivida;
    private String motivoInadiplencia;
    private String statusDivida;
    private String nomeEmpresa;
    private String cnpjEmpresa;



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getDataInclusaoDivida() {
        return dataInclusaoDivida;
    }

    public void setDataInclusaoDivida(LocalDateTime dataInclusaoDivida) {
        this.dataInclusaoDivida = dataInclusaoDivida;
    }

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

    public String getStatusDivida() {
        return statusDivida;
    }

    public void setStatusDivida(String statusDivida) {
        this.statusDivida = statusDivida;
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
