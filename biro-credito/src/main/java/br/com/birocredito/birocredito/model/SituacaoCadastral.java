package br.com.birocredito.birocredito.model;

import br.com.birocredito.birocredito.enuns.StatusCadastral;

import javax.persistence.*;
import java.util.Date;

@Entity
public class SituacaoCadastral {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date dataConsulta;

    private Long score;

    @Enumerated(EnumType.STRING)
    private StatusCadastral status;

    public StatusCadastral getStatus() {
        return status;
    }

    public void setStatus(StatusCadastral status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getScore() {
        return score;
    }

    public void setScore(Long score) {
        this.score = score;
    }


    public Date getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(Date dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    @PrePersist
    public void prePersistData(){
        this.dataConsulta = new Date();
    }


}
