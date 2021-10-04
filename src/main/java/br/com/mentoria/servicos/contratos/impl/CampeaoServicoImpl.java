package br.com.mentoria.servicos.contratos.impl;

import br.com.mentoria.adaptadores.CampeaoEntidadeAdapter;
import br.com.mentoria.adaptadores.CapeaoServiceAdpter;
import br.com.mentoria.bd.contratos.RepositorioCampeaoEntity;
import br.com.mentoria.servicos.contratos.CampeaoServico;
import br.com.mentoria.servicos.entidades.Campeao;
import br.com.mentoria.servicos.entidades.enums.TipoCampeaoEnum;
import br.com.mentoria.servicos.exececoes.CampeaoException;
import br.com.mentoria.servicos.util.EmailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CampeaoServicoImpl implements CampeaoServico {

    private RepositorioCampeaoEntity campeaoRepositorio;

    @Autowired
    public CampeaoServicoImpl(RepositorioCampeaoEntity campeaoRepositorio){
        this.campeaoRepositorio = campeaoRepositorio;
    }

    @Override
    public boolean salvarCampeao(Campeao campeao) throws CampeaoException {
        validaCampeao(campeao);
        if (campeao.getTipo().getNomeTecnico().equals(TipoCampeaoEnum.JEDI.toString())) {
            campeao = criarJedi(campeao);
        } else if (campeao.getTipo().getNomeTecnico().equals(TipoCampeaoEnum.SITH.toString())){
            campeao = criarSith(campeao);
        }else{
            throw new CampeaoException("Um tipo de campeão não existente foi selecionado");
        }

        campeaoRepositorio.save((new CampeaoEntidadeAdapter(campeao)).getCampeaoEntidade());


        return campeao.getHp() != null;
    }

    @Override
    public List<Campeao> listarTodos() {
        return new CapeaoServiceAdpter(campeaoRepositorio.findAll()).getCampeoes();
    }

    private Campeao criarJedi(Campeao campeao) {
        System.out.println("CRIOU UM JEDI");
        return Campeao.builder()
                .nome(campeao.getNome())
                .email(campeao.getEmail())
                .corSabre(campeao.getCorSabre())
                .tipo(campeao.getTipo())
                .afinadadeForca(5L)
                .forcaFisica(5L)
                .hp(150L)
                .habilidadeComSabre(5L)
                .mental(10L)
                .previsao(5L)
                .build();
    }


    private Campeao criarSith(Campeao campeao) {
        System.out.println("CRIOU UM SITH");
        return Campeao.builder()
                .nome(campeao.getNome())
                .email(campeao.getEmail())
                .corSabre(campeao.getCorSabre())
                .tipo(campeao.getTipo())
                .afinadadeForca(5L)
                .forcaFisica(10L)
                .hp(150L)
                .habilidadeComSabre(5L)
                .mental(5L)
                .previsao(5L)
                .build();
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
