package builders;

import br.com.mentoria.bd.entidades.CampeaoEntidade;
import br.com.mentoria.servicos.entidades.Campeao;

public class CampeaoBuilder {

    public static Campeao campeaoBuilder(){
        return Campeao.builder()
                .tipo(TipoCampeaoBuilder.tipoCampeaoBuilder())
                .habilidadeComSabre(5L)
                .email("bananinha@xprto.com")
                .forcaFisica(5L)
                .nome("Bananinha")
                .corSabre("Amarelo")
                .mental(5L)
                .previsao(5L)
                .hp(150L)
                .afinadadeForca(50L)
                .build();
    }

    public static CampeaoEntidade campeaoEntidadeBuilder(){
        return CampeaoEntidade.builder()
                .tipo(TipoCampeaoBuilder.tipoCampeaoEntidadeBuilder())
                .habilidadeComSabre(5L)
                .email("bananinha@xprto.com")
                .forcaFisica(5L)
                .nome("Bananinha")
                .corSabre("Amarelo")
                .mental(5L)
                .previsao(5L)
                .hp(150L)
                .afinadadeForca(50L)
                .build();
    }
}
