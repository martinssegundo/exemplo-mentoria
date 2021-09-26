package br.com.mentoria.adaptadores;

import br.com.mentoria.apis.entidades.CampeaoAPI;
import br.com.mentoria.servicos.entidades.Campeao;
import br.com.mentoria.servicos.entidades.enums.TipoCampeao;
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
                .jedi(campeao.getTipo().equals(TipoCampeao.JEDI)?true:false)
                .build();
    }

}
