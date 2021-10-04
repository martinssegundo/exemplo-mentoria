package br.com.mentoria.bd.contratos;

import br.com.mentoria.bd.entidades.TipoCampeaoEntidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioTipoCampeao extends JpaRepository<TipoCampeaoEntidade,Long> {

    @Query(value = "select tc from TipoCampeaoEntidade tc " +
            "where tc.nomeTecnico like :nomeTecnico")
    public TipoCampeaoEntidade findByNomeTecnico(@Param("nomeTecnico") String nomeTecnico);
}
