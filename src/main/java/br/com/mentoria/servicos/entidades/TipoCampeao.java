package br.com.mentoria.servicos.entidades;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TipoCampeao {
    private Long id;
    private String nomeTecnico;
    private String descricao;
}
