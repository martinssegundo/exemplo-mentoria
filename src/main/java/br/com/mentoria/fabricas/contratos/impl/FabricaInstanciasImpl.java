package br.com.mentoria.fabricas.contratos.impl;

import br.com.mentoria.bd.contratos.RepositorioCampeaoEntity;
import br.com.mentoria.bd.contratos.RepositorioTipoCampeaoEntity;
import br.com.mentoria.fabricas.contratos.FabricaInstancias;
import br.com.mentoria.servicos.contratos.CampeaoServico;
import br.com.mentoria.servicos.contratos.impl.CampeaoServicoImpl;
import br.com.mentoria.servicos.entidades.TipoCampeao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FabricaInstanciasImpl implements FabricaInstancias {

    private RepositorioCampeaoEntity repositorioCampeaoEntity;
    private RepositorioTipoCampeaoEntity repositorioTipoCampeaoEntity;


    @Autowired
    private FabricaInstanciasImpl(RepositorioCampeaoEntity repositorioCampeaoEntity,
                                  RepositorioTipoCampeaoEntity repositorioTipoCampeaoEntity){
        this.repositorioCampeaoEntity = repositorioCampeaoEntity;
        this.repositorioTipoCampeaoEntity = repositorioTipoCampeaoEntity;
    }



    @Override
    public CampeaoServico getCampeaoServicoImple() {
        return CampeaoServicoImpl.getInstance(repositorioCampeaoEntity, repositorioTipoCampeaoEntity);
    }

    @Override
    public TipoCampeao getTipoCampeaoImple() {
        return null;
    }
}
