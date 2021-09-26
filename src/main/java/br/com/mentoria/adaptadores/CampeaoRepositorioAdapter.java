package br.com.mentoria.adaptadores;

import br.com.mentoria.bd.entidades.CampeaoEntity;
import br.com.mentoria.servicos.entidades.Campeao;
import lombok.Data;

@Data
public class CampeaoRepositorioAdapter {

    private CampeaoEntity campeaoEntity;

    public CampeaoRepositorioAdapter(Campeao campeao){
        converteCampeaoEmCampeaoEntity(campeao);
    }

    private void converteCampeaoEmCampeaoEntity(Campeao campeao){
        campeaoEntity = campeaoEntity.builder()
                .corSabre(campeao.getCorSabre())
                .email(campeao.getEmail())
                .nome(campeao.getNome())
                .afinadadeForca(campeao.getAfinadadeForca())
                .forcaFisica(campeao.getForcaFisica())
                .hp(campeao.getHp())
                .habilidadeComSabre(campeao.getHabilidadeComSabre())
                .mental(campeao.getMental())
                .previsao(campeao.getPrevisao())
                .build();
    }
}
