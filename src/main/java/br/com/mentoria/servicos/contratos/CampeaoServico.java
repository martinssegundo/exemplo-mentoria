package br.com.mentoria.servicos.contratos;

import br.com.mentoria.servicos.entidades.Campeao;
import br.com.mentoria.servicos.exececoes.CampeaoException;

public interface CampeaoServico {

    boolean salvarCampeao(Campeao campeao) throws CampeaoException;
}
