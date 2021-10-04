package br.com.mentoria.servicos.contratos.impl;

import br.com.mentoria.adaptadores.tipoCampeao.TipoCampeaoAdapter;
import br.com.mentoria.bd.contratos.RepositorioTipoCampeao;
import br.com.mentoria.servicos.contratos.TipoCampeaoService;
import br.com.mentoria.servicos.entidades.TipoCampeao;
import br.com.mentoria.servicos.exececoes.TipoCampeaoException;

public class TipoCampeaoServiceImpl implements TipoCampeaoService {

    private RepositorioTipoCampeao repositorioTipoCampeao;

    public TipoCampeaoServiceImpl(RepositorioTipoCampeao repositorioTipoCampeao){
        this.repositorioTipoCampeao = repositorioTipoCampeao;
    }

    @Override
    public TipoCampeao biscaTipoCampeaoPorNomeTecnico(String nomeTecnico) throws TipoCampeaoException {
        TipoCampeao tipoCampeao = new TipoCampeaoAdapter(
                repositorioTipoCampeao.findByNomeTecnico(nomeTecnico)
        ).getTipoCampeao();
        if(tipoCampeao == null
            || tipoCampeao.getNomeTecnico() == null){
            throw new TipoCampeaoException("Tipo de campeão não encontrado");
        }
        return tipoCampeao;
    }
}
