package br.com.mentoria.bd.contratos;

import br.com.mentoria.bd.entidades.CampeaoEntidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioCampeaoEntity extends JpaRepository<CampeaoEntidade, Long> {


    public CampeaoEntidade findByEmail(String email);

    @Query(value = "Select c " +
            " from CampeaoEntidade c " +
            " where c.lvl BETWEEN :lvlInicio AND :lvlFim")
    public List<CampeaoEntidade> findDesafianteByLvl(@Param("lvlInicio") Long lvlInicio,
                                                     @Param("lvlFim") Long lvlFim);

}
