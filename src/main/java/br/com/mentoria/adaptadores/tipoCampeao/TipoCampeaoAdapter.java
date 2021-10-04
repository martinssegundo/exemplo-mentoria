package br.com.mentoria.adaptadores.tipoCampeao;

import br.com.mentoria.apis.entidades.TipoCampeaoAPI;
import br.com.mentoria.bd.entidades.TipoCampeaoEntidade;
import br.com.mentoria.servicos.entidades.TipoCampeao;
import lombok.Data;

@Data
public class TipoCampeaoAdapter {

    private TipoCampeao tipoCampeao;

    public TipoCampeaoAdapter(TipoCampeaoAPI campeaoAPI){
        this.tipoCampeao = converterTipoCampeaoAPIEmTipoCampeao(campeaoAPI);
    }

    public TipoCampeaoAdapter(TipoCampeaoEntidade tipoCampeaoEntidade){
        this.tipoCampeao = converteTipoCampeaoEntidadeEmTipoCampeao(tipoCampeaoEntidade);
    }

    private TipoCampeao converterTipoCampeaoAPIEmTipoCampeao(TipoCampeaoAPI campeaoAPI){
        return TipoCampeao.builder()
                .descricao(campeaoAPI.getDescricao())
                .nomeTecnico(campeaoAPI.getNomeTecnico())
                .build();
    }

    private TipoCampeao converteTipoCampeaoEntidadeEmTipoCampeao(TipoCampeaoEntidade tipoCampeaoEntidade){
        if(tipoCampeaoEntidade != null){
            return TipoCampeao.builder()
                    .id(tipoCampeaoEntidade.getId())
                    .descricao(tipoCampeaoEntidade.getTipoCampeao())
                    .nomeTecnico(tipoCampeaoEntidade.getNomeTecnico())
                    .build();
        }else
            return TipoCampeao.builder().build();
    }
}
