package br.com.mentoria.servicos.contratos;

import br.com.mentoria.servicos.entidades.TipoCampeao;
import br.com.mentoria.servicos.exececoes.TipoCampeaoException;
import org.springframework.stereotype.Service;

@Service
public interface TipoCampeaoService {
    public TipoCampeao biscaTipoCampeaoPorNomeTecnico(String nomeTecnico) throws TipoCampeaoException;
}
