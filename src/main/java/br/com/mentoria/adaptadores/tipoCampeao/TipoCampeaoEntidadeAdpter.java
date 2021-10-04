package br.com.mentoria.adaptadores.tipoCampeao;

import br.com.mentoria.bd.contratos.RepositorioTipoCampeao;
import br.com.mentoria.bd.entidades.TipoCampeaoEntidade;
import br.com.mentoria.servicos.entidades.TipoCampeao;
import lombok.Data;

@Data
public class TipoCampeaoEntidadeAdpter {

    private TipoCampeaoEntidade tipoCampeaoEntidade;

    public TipoCampeaoEntidadeAdpter(TipoCampeao tipoCampeao,
                                     RepositorioTipoCampeao repositorioTipoCampeao){
        this.tipoCampeaoEntidade = converterTipoCampeaoEmTipoCampeaoEntidade(
                tipoCampeao,
                repositorioTipoCampeao
        );
    }

    private TipoCampeaoEntidade converterTipoCampeaoEmTipoCampeaoEntidade(
            TipoCampeao tipoCampeao,
            RepositorioTipoCampeao repositorioTipoCampeao){
        return repositorioTipoCampeao.findByNomeTecnico(tipoCampeao.getNomeTecnico());
    }
}
