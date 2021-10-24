package br.com.mentoria.apis.entidades;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CampeaoAPI {
    private String nome;
    private String email;
    private String corSabre;
    private TipoCampeaoAPI tipoCapeao;
    private String erro;

    private Long hp;
    private Long forcaFisica;
    private Long mental;
    private Long previsao;
    private Long habilidadeComSabre;
    private Long afinadadeForca;
}
