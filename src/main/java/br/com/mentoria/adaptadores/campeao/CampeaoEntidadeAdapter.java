package br.com.mentoria.adaptadores.campeao;

import br.com.mentoria.adaptadores.tipoCampeao.TipoCampeaoEntidadeAdpter;
import br.com.mentoria.bd.contratos.RepositorioTipoCampeao;
import br.com.mentoria.bd.entidades.CampeaoEntidade;
import br.com.mentoria.servicos.entidades.Campeao;
import lombok.Data;

@Data
public class CampeaoEntidadeAdapter {

    private CampeaoEntidade campeaoEntidade;

    public CampeaoEntidadeAdapter(Campeao campeao, RepositorioTipoCampeao repositorioTipoCampeao){
        converteCampeaoEmCampeaoEntity(campeao, repositorioTipoCampeao);
    }

    private void converteCampeaoEmCampeaoEntity(Campeao campeao,
                                                RepositorioTipoCampeao repositorioTipoCampeao){
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
                .tipo(new TipoCampeaoEntidadeAdpter(campeao.getTipo(),repositorioTipoCampeao)
                        .getTipoCampeaoEntidade()
                )
                .build();
    }
}
