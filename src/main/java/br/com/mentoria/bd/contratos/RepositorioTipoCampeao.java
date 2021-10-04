package br.com.mentoria.bd.contratos;

import br.com.mentoria.bd.entidades.TipoCampeaoEntidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioTipoCampeao extends JpaRepository<TipoCampeaoEntidade,Long> {

    public TipoCampeaoEntidade findByNomeTecnico(String nomeTecnico);
}
