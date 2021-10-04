package br.com.mentoria.adaptadores.tipoCampeao;

import br.com.mentoria.apis.entidades.TipoCampeaoAPI;
import br.com.mentoria.servicos.entidades.TipoCampeao;
import lombok.Data;

@Data
public class TipoCampeaoAPIAdpter {

    private TipoCampeaoAPI campeaoAPI;

    public TipoCampeaoAPIAdpter(TipoCampeao tipoCampeao){
        this.campeaoAPI = converteTipoCampeamEmTipoCampeaoAPI(tipoCampeao);
    }


    private TipoCampeaoAPI converteTipoCampeamEmTipoCampeaoAPI(TipoCampeao tipoCampeao){
        return TipoCampeaoAPI.builder()
                .descricao(tipoCampeao.getDescricao())
                .nomeTecnico(tipoCampeao.getNomeTecnico())
                .build();
    }
}
