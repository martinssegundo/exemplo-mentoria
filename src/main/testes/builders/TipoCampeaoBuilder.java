package builders;

import br.com.mentoria.bd.entidades.TipoCampeaoEntidade;
import br.com.mentoria.servicos.entidades.TipoCampeao;

public class TipoCampeaoBuilder {

    public static TipoCampeao tipoCampeaoBuilder(){
        return TipoCampeao.builder()
                .id(1L)
                .descricao("ABC")
                .nomeTecnico("JEDI")
                .build();
    }

    public static TipoCampeaoEntidade tipoCampeaoEntidadeBuilder(){
        return TipoCampeaoEntidade.builder()
                .id(1L)
                .tipoCampeao("ABC")
                .nomeTecnico("JEDI")
                .build();
    }
}
