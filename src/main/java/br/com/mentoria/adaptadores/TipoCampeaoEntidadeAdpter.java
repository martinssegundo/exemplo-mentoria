package br.com.mentoria.adaptadores;

import br.com.mentoria.bd.contratos.RepositorioTipoCampeao;
import br.com.mentoria.bd.entidades.TipoCampeaoEntidade;
import br.com.mentoria.servicos.entidades.TipoCampeao;
import lombok.Data;

@Data
public class TipoCampeaoEntidadeAdpter {

    private TipoCampeaoEntidade tipoCampeaoEntidade;

    private RepositorioTipoCampeao repositorioTipoCampeao;

    public TipoCampeaoEntidadeAdpter(TipoCampeao tipoCampeao){
        this.tipoCampeaoEntidade = converterTipoCampeaoEmTipoCampeaoEntidade(tipoCampeao);
    }

    private TipoCampeaoEntidade converterTipoCampeaoEmTipoCampeaoEntidade(TipoCampeao tipoCampeao){
        return repositorioTipoCampeao.findByNomeTecnico(tipoCampeao.getNomeTecnico());
    }
}
