package br.com.mentoria.servicos.entidades;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RetornoCampeao {
    private Campeao campeaoDesafiante;
    private Campeao campeaoDesafiado;
}
