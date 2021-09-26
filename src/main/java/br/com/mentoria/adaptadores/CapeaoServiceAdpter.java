package br.com.mentoria.adaptadores;

import br.com.mentoria.apis.entidades.CampeaoAPI;
import br.com.mentoria.bd.entidades.CampeaoEntity;
import br.com.mentoria.servicos.entidades.Campeao;
import br.com.mentoria.servicos.entidades.enums.TipoCampeao;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CapeaoServiceAdpter {

    private Campeao campeao;
    private List<Campeao> campeoes;

    public CapeaoServiceAdpter(CampeaoAPI campeaoAPI){
        this.campeao = convertCampeaoDTOEmCampeao(campeaoAPI);
    }

    public CapeaoServiceAdpter(CampeaoEntity campeaoEntity){
        this.campeao = convertCampeaoEntityEmCampeao(campeaoEntity);
    }

    public CapeaoServiceAdpter(List<CampeaoEntity> campeaoEntities){
        campeoes = convertListEntityEmListCampeao(campeaoEntities);
    }


    private List<Campeao> convertListEntityEmListCampeao(List<CampeaoEntity> campeaoEntityList){
        campeoes = new ArrayList<>();
        for (CampeaoEntity campeaoEntity : campeaoEntityList) {
            campeoes.add(convertCampeaoEntityEmCampeao(campeaoEntity));
        }
        return campeoes;
    }

    private Campeao convertCampeaoDTOEmCampeao(CampeaoAPI campeaoAPI){
        return Campeao.builder()
                .email(campeaoAPI.getEmail())
                .nome(campeaoAPI.getNome())
                .corSabre(campeaoAPI.getCorSabre())
                .tipo(campeaoAPI.isJedi()? TipoCampeao.JEDI :TipoCampeao.SITH)
                .build();
    }

    private Campeao convertCampeaoEntityEmCampeao(CampeaoEntity campeaoEntity){
        return Campeao.builder()
                .hp(campeaoEntity.getHp())
                .afinadadeForca(campeaoEntity.getAfinadadeForca())
                .previsao(campeaoEntity.getPrevisao())
                .mental(campeaoEntity.getMental())
                .corSabre(campeaoEntity.getCorSabre())
                .nome(campeaoEntity.getNome())
                .forcaFisica(campeaoEntity.getForcaFisica())
                .email(campeaoEntity.getEmail())
                .habilidadeComSabre(campeaoEntity.getHabilidadeComSabre())
                .tipo(
                    TipoCampeao.getTipoCampeao(
                        (campeaoEntity.getTipo() != null?campeaoEntity.getTipo().getId():null)
                    )
                )
                .build();
    }
}
