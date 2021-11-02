package br.com.mentoria.apis.entidades.combate;

import br.com.mentoria.apis.entidades.CampeaoAPI;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RetornoCampeaoCombateAPI {
    private CampeaoAPI campeaoSolicitanteCombate;
    private CampeaoAPI campeaoDesafiado;
}
