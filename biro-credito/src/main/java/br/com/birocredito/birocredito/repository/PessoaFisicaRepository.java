package br.com.birocredito.birocredito.repository;

import br.com.birocredito.birocredito.model.PessoaFisica;
import br.com.birocredito.birocredito.model.SituacaoCadastral;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaFisicaRepository extends JpaRepository<PessoaFisica, Long> {
}
