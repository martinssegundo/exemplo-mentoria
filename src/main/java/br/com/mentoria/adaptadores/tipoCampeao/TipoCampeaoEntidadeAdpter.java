package br.com.mentoria.adaptadores.tipoCampeao;

import br.com.mentoria.bd.contratos.RepositorioTipoCampeaoEntity;
import br.com.mentoria.bd.entidades.TipoCampeaoEntidade;
import br.com.mentoria.servicos.entidades.TipoCampeao;
import lombok.Data;

@Data
public class TipoCampeaoEntidadeAdpter {

    private TipoCampeaoEntidade tipoCampeaoEntidade;

    public TipoCampeaoEntidadeAdpter(TipoCampeao tipoCampeao,
                                     RepositorioTipoCampeaoEntity repositorioTipoCampeaoEntity){
        this.tipoCampeaoEntidade = converterTipoCampeaoEmTipoCampeaoEntidade(
                tipoCampeao,
                repositorioTipoCampeaoEntity
        );
    }

    private TipoCampeaoEntidade converterTipoCampeaoEmTipoCampeaoEntidade(
            TipoCampeao tipoCampeao,
            RepositorioTipoCampeaoEntity repositorioTipoCampeaoEntity){
        return repositorioTipoCampeaoEntity.findByNomeTecnico(tipoCampeao.getNomeTecnico());
    }
}
