package br.com.mentoria.apis.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NovoCampeaoDTO {
    private String nome;
    private String email;
    private String corSabre;
    private boolean jedi;
}
