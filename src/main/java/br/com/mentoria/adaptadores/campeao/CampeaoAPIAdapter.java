package br.com.mentoria.adaptadores.campeao;

import br.com.mentoria.adaptadores.tipoCampeao.TipoCampeaoAPIAdpter;
import br.com.mentoria.apis.entidades.CampeaoAPI;
import br.com.mentoria.servicos.entidades.Campeao;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CampeaoAPIAdapter {
    private CampeaoAPI campeaoAPI;
    private List<CampeaoAPI> campeaoAPIS;

    public CampeaoAPIAdapter(Campeao campeao){
        campeaoAPI = converteCapeaoParaCapeaoAPI(campeao);
    }

    public CampeaoAPIAdapter(List<Campeao> campeao){
        campeaoAPIS = converteListaCampeaoParaListaCampeaoAPI(campeao);
    }

    private List<CampeaoAPI> converteListaCampeaoParaListaCampeaoAPI(List<Campeao> campeoes){
        List<CampeaoAPI> campeaoAPIS = new ArrayList<>();
        for (Campeao campeao:campeoes) {
            campeaoAPIS.add(converteCapeaoParaCapeaoAPI(campeao));
        }
        return campeaoAPIS;
    }


    private CampeaoAPI converteCapeaoParaCapeaoAPI(Campeao campeao){
        return CampeaoAPI.builder()
                .email(campeao.getEmail())
                .corSabre(campeao.getCorSabre())
                .nome(campeao.getNome())
                .tipoCapeao(new TipoCampeaoAPIAdpter(campeao.getTipo()).getCampeaoAPI())
                .hp(campeao.getHp())
                .afinadadeForca(campeao.getAfinadadeForca())
                .forcaFisica(campeao.getForcaFisica())
                .habilidadeComSabre(campeao.getHabilidadeComSabre())
                .mental(campeao.getMental())
                .previsao(campeao.getPrevisao())
                .build();
    }

}
