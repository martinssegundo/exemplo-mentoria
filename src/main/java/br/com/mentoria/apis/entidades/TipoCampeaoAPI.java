package br.com.mentoria.apis.entidades;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TipoCampeaoAPI {

    private String nomeTecnico;
    private String descricao;
}
