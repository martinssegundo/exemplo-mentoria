package br.com.mentoria.servicos.contratos;

import br.com.mentoria.servicos.entidades.Campeao;
import br.com.mentoria.servicos.entidades.RetornoCampeao;
import br.com.mentoria.servicos.exececoes.CampeaoException;

import java.util.List;

public interface CampeaoServico {

    boolean salvarCampeao(Campeao campeao) throws CampeaoException;

    List<Campeao> listarTodos();

    Campeao encotraCampeao(String email);

    RetornoCampeao buscarCapeaosCombate(String email);
}
