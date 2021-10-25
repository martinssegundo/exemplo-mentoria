package br.com.mentoria.servicos.contratos.impl;

import br.com.mentoria.adaptadores.tipoCampeao.TipoCampeaoAdapter;
import br.com.mentoria.bd.contratos.RepositorioTipoCampeaoEntity;
import br.com.mentoria.servicos.contratos.TipoCampeaoService;
import br.com.mentoria.servicos.entidades.TipoCampeao;
import br.com.mentoria.servicos.exececoes.TipoCampeaoException;

public class TipoCampeaoServiceImpl implements TipoCampeaoService {

    private RepositorioTipoCampeaoEntity repositorioTipoCampeaoEntity;

    private static TipoCampeaoService instance;

    private TipoCampeaoServiceImpl(RepositorioTipoCampeaoEntity repositorioTipoCampeaoEntity){
        this.repositorioTipoCampeaoEntity = repositorioTipoCampeaoEntity;
    }

    public static TipoCampeaoService getInstance(RepositorioTipoCampeaoEntity repositorioTipoCampeaoEntity){
        if(instance == null){
            instance = new TipoCampeaoServiceImpl(repositorioTipoCampeaoEntity);
        }
        return instance;
    }


    @Override
    public TipoCampeao biscaTipoCampeaoPorNomeTecnico(String nomeTecnico) throws TipoCampeaoException {
        TipoCampeao tipoCampeao = new TipoCampeaoAdapter(
                repositorioTipoCampeaoEntity.findByNomeTecnico(nomeTecnico)
        ).getTipoCampeao();
        if(tipoCampeao == null
            || tipoCampeao.getNomeTecnico() == null){
            throw new TipoCampeaoException("Tipo de campeão não encontrado");
        }
        return tipoCampeao;
    }
}
