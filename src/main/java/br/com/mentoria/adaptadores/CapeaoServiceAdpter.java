package br.com.mentoria.adaptadores;

import br.com.mentoria.apis.entidades.NovoCampeaoDTO;
import br.com.mentoria.servicos.entidades.Campeao;
import lombok.Data;

@Data
public class CapeaoServiceAdpter {

    private Campeao campeao;

    public CapeaoServiceAdpter(NovoCampeaoDTO novoCampeaoDTO){
        convertCampeaoDTOemCampeao(novoCampeaoDTO);
    }


    private void convertCampeaoDTOemCampeao(NovoCampeaoDTO novoCampeaoDTO){
        campeao = Campeao.builder()
                .email(novoCampeaoDTO.getEmail())
                .nome(novoCampeaoDTO.getNome())
                .corSabre(novoCampeaoDTO.getCorSabre())
                .tipo(novoCampeaoDTO.isJedi()?"jedi":"sith")
                .build();
    }
}
