package br.com.mentoria.servicos.util;

import br.com.mentoria.servicos.entidades.Campeao;

public class CampeaoUtil {

    private CampeaoUtil(){}

    //TODO: Alterar para receber valores do properties
    public static Long maiorLevelDesafiado(Long lvlCampeaoDesafiante){
        return lvlCampeaoDesafiante + 5;
    }

    //TODO: Alterar para receber valores do properties
    public static Long menorLevelDesafiado(Long lvlCampeaoDesafiante){
        return lvlCampeaoDesafiante - 5;
    }

    public static Campeao criarJedi(Campeao campeao) {
        System.out.println("CRIOU UM JEDI");
        return Campeao.builder()
                .nome(campeao.getNome())
                .email(campeao.getEmail())
                .corSabre(campeao.getCorSabre())
                .tipo(campeao.getTipo())
                .afinadadeForca(5L)
                .forcaFisica(5L)
                .hp(150L)
                .habilidadeComSabre(5L)
                .mental(10L)
                .previsao(5L)
                .build();
    }

    public static Campeao criarSith(Campeao campeao) {
        System.out.println("CRIOU UM SITH");
        return Campeao.builder()
                .nome(campeao.getNome())
                .email(campeao.getEmail())
                .corSabre(campeao.getCorSabre())
                .tipo(campeao.getTipo())
                .afinadadeForca(5L)
                .forcaFisica(10L)
                .hp(150L)
                .habilidadeComSabre(5L)
                .mental(5L)
                .previsao(5L)
                .build();
    }
}
