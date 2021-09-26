package br.com.mentoria.servicos.entidades;

import br.com.mentoria.servicos.entidades.enums.TipoCampeao;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Campeao {
    private String nome;
    private String email;
    private String corSabre;
    private TipoCampeao tipo;
    private Long hp;
    private Long forcaFisica;
    private Long mental;
    private Long previsao;
    private Long habilidadeComSabre;
    private Long afinadadeForca;
}

