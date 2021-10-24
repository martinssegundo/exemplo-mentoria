package br.com.mentoria.servicos.contratos.impl;

import br.com.mentoria.adaptadores.campeao.CampeaoEntidadeAdapter;
import br.com.mentoria.adaptadores.campeao.CapeaoServiceAdpter;
import br.com.mentoria.bd.contratos.RepositorioCampeaoEntity;
import br.com.mentoria.bd.contratos.RepositorioTipoCampeao;
import br.com.mentoria.servicos.contratos.CampeaoServico;
import br.com.mentoria.servicos.entidades.Campeao;
import br.com.mentoria.servicos.entidades.enums.TipoCampeaoEnum;
import br.com.mentoria.servicos.exececoes.CampeaoException;
import br.com.mentoria.servicos.util.CampeaoUtil;
import br.com.mentoria.servicos.util.EmailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CampeaoServicoImpl implements CampeaoServico {

    private RepositorioCampeaoEntity campeaoRepositorio;
    private RepositorioTipoCampeao repositorioTipoCampeao;

    @Autowired
    public CampeaoServicoImpl(RepositorioCampeaoEntity campeaoRepositorio,
                              RepositorioTipoCampeao repositorioTipoCampeao){
        this.campeaoRepositorio = campeaoRepositorio;
        this.repositorioTipoCampeao = repositorioTipoCampeao;
    }

    @Override
    public boolean salvarCampeao(Campeao campeao) throws CampeaoException {
        validaCampeao(campeao);
        if (campeao.getTipo().getNomeTecnico().equals(TipoCampeaoEnum.JEDI.toString())) {
            campeao = CampeaoUtil.criarJedi(campeao);
        } else if (campeao.getTipo().getNomeTecnico().equals(TipoCampeaoEnum.SITH.toString())){
            campeao = CampeaoUtil.criarSith(campeao);
        }else{
            throw new CampeaoException("Um tipo de campeão não existente foi selecionado");
        }

        campeaoRepositorio.save(new CampeaoEntidadeAdapter(campeao, repositorioTipoCampeao)
                .getCampeaoEntidade());


        return campeao.getHp() != null;
    }

    @Override
    public List<Campeao> listarTodos() {
        return new CapeaoServiceAdpter(campeaoRepositorio.findAll()).getCampeoes();
    }

    @Override
    public Campeao encotraCampeao(String email) {
        return new CapeaoServiceAdpter(campeaoRepositorio.findByEmail(email)).getCampeao();
    }


    private void validaCampeao(Campeao campeao) throws CampeaoException {
        if (!EmailUtil.verificaEmamilValido(campeao.getEmail())) {
            throw new CampeaoException("O email digitado é invalido");
        }
        if (campeao.getNome() == null
            || campeao.getNome().isEmpty()){
            throw new CampeaoException("O nome é invalido");
        }
        if(campeao.getCorSabre() == null
            || campeao.getCorSabre().isEmpty()){
            throw new CampeaoException("A cor do saber é invalida");
        }
    }
}
