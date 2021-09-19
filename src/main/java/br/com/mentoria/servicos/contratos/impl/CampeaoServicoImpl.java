package br.com.mentoria.servicos.contratos.impl;

import br.com.mentoria.servicos.contratos.CampeaoServico;
import br.com.mentoria.servicos.entidades.Campeao;
import br.com.mentoria.servicos.exececoes.CampeaoException;
import br.com.mentoria.servicos.util.EmailUtil;
import org.springframework.stereotype.Service;

@Service
public class CampeaoServicoImpl implements CampeaoServico {


    @Override
    public boolean salvarCampeao(Campeao campeao) throws CampeaoException {
        validaCampeao(campeao);
        if (campeao.getTipo().equals("jedi") ) {
            campeao = criarJedi(campeao);
        } else {
            campeao = criarSith(campeao);
        }
        return campeao.getHp() != null;
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
