package br.com.mentoria.adaptadores;

import br.com.mentoria.bd.entidades.CampeaoEntidade;
import br.com.mentoria.servicos.entidades.Campeao;
import lombok.Data;

@Data
public class CampeaoEntidadeAdapter {

    private CampeaoEntidade campeaoEntidade;

    public CampeaoEntidadeAdapter(Campeao campeao){
        converteCampeaoEmCampeaoEntity(campeao);
    }

    private void converteCampeaoEmCampeaoEntity(Campeao campeao){
        campeaoEntidade = campeaoEntidade.builder()
                .corSabre(campeao.getCorSabre())
                .email(campeao.getEmail())
                .nome(campeao.getNome())
                .afinadadeForca(campeao.getAfinadadeForca())
                .forcaFisica(campeao.getForcaFisica())
                .hp(campeao.getHp())
                .habilidadeComSabre(campeao.getHabilidadeComSabre())
                .mental(campeao.getMental())
                .previsao(campeao.getPrevisao())
                .tipo(new TipoCampeaoEntidadeAdpter(campeao.getTipo()).getTipoCampeaoEntidade())
                .build();
    }
}
