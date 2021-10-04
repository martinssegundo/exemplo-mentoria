package br.com.mentoria.bd.contratos;

import br.com.mentoria.bd.entidades.CampeaoEntidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioCampeaoEntity extends JpaRepository<CampeaoEntidade, Long> {
}
