package br.com.mentoria.adaptadores.campeao;

import br.com.mentoria.adaptadores.tipoCampeao.TipoCampeaoEntidadeAdpter;
import br.com.mentoria.bd.contratos.RepositorioTipoCampeaoEntity;
import br.com.mentoria.bd.entidades.CampeaoEntidade;
import br.com.mentoria.servicos.entidades.Campeao;
import lombok.Data;

@Data
public class CampeaoEntidadeAdapter {

    private CampeaoEntidade campeaoEntidade;

    public CampeaoEntidadeAdapter(Campeao campeao, RepositorioTipoCampeaoEntity repositorioTipoCampeaoEntity){
        converteCampeaoEmCampeaoEntity(campeao, repositorioTipoCampeaoEntity);
    }

    private void converteCampeaoEmCampeaoEntity(Campeao campeao,
                                                RepositorioTipoCampeaoEntity repositorioTipoCampeaoEntity){
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
                .tipo(new TipoCampeaoEntidadeAdpter(campeao.getTipo(), repositorioTipoCampeaoEntity)
                        .getTipoCampeaoEntidade()
                )
                .build();
    }
}
