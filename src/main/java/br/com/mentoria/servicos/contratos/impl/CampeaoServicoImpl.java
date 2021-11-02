package br.com.mentoria.servicos.contratos.impl;

import br.com.mentoria.adaptadores.campeao.CampeaoEntidadeAdapter;
import br.com.mentoria.adaptadores.campeao.CapeaoServiceAdpter;
import br.com.mentoria.bd.contratos.RepositorioCampeaoEntity;
import br.com.mentoria.bd.contratos.RepositorioTipoCampeaoEntity;
import br.com.mentoria.servicos.contratos.CampeaoServico;
import br.com.mentoria.servicos.entidades.Campeao;
import br.com.mentoria.servicos.entidades.RetornoCampeao;
import br.com.mentoria.servicos.entidades.enums.TipoCampeaoEnum;
import br.com.mentoria.servicos.exececoes.CampeaoException;
import br.com.mentoria.servicos.util.CampeaoUtil;
import br.com.mentoria.servicos.util.EmailUtil;

import java.util.List;

public class CampeaoServicoImpl implements CampeaoServico {

    private RepositorioCampeaoEntity campeaoRepositorio;
    private RepositorioTipoCampeaoEntity repositorioTipoCampeaoEntity;

    private static CampeaoServico instance;


    private CampeaoServicoImpl(RepositorioCampeaoEntity campeaoRepositorio,
                              RepositorioTipoCampeaoEntity repositorioTipoCampeaoEntity){
        this.campeaoRepositorio = campeaoRepositorio;
        this.repositorioTipoCampeaoEntity = repositorioTipoCampeaoEntity;
    }

    public static CampeaoServico getInstance(RepositorioCampeaoEntity campeaoRepositorio,
                                             RepositorioTipoCampeaoEntity repositorioTipoCampeaoEntity){
        if(instance == null){
            instance = new CampeaoServicoImpl(campeaoRepositorio, repositorioTipoCampeaoEntity);
        }
        return instance;
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

        campeaoRepositorio.save(new CampeaoEntidadeAdapter(campeao, repositorioTipoCampeaoEntity)
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

    @Override
    public RetornoCampeao buscarCapeaosCombate(String email) {
        Campeao campeaoDesafiante = encotraCampeao(email);


        return null;
    }


    private Campeao getCampeaoDesafiado(Campeao campeaoDesafiante){
        List<Campeao> campeoesDesafiados =
                new CapeaoServiceAdpter(campeaoRepositorio.findDesafianteByLvl(
                        CampeaoUtil.menorLevelDesafiado(campeaoDesafiante.getLevel()),
                        CampeaoUtil.maiorLevelDesafiado(campeaoDesafiante.getLevel())))
                        .getCampeoes();

        


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
