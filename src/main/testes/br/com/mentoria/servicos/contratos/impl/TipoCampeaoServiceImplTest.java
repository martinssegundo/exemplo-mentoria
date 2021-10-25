package br.com.mentoria.servicos.contratos.impl;

import br.com.mentoria.bd.contratos.RepositorioTipoCampeaoEntity;
import br.com.mentoria.bd.entidades.TipoCampeaoEntidade;
import br.com.mentoria.servicos.entidades.TipoCampeao;

import br.com.mentoria.servicos.exececoes.TipoCampeaoException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;

import static org.mockito.Mockito.*;

public class TipoCampeaoServiceImplTest {
    @Mock
    RepositorioTipoCampeaoEntity repositorioTipoCampeaoEntity;
    @InjectMocks
    TipoCampeaoServiceImpl tipoCampeaoServiceImpl;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testBiscaTipoCampeaoPorNomeTecnico() throws Exception {
        TipoCampeaoEntidade envio = TipoCampeaoEntidade.builder()
                                        .id(Long.valueOf(1))
                                        .nomeTecnico("nomeTecnico")
                                        .tipoCampeao("tipoCampeao")
                                        .build();

        when(repositorioTipoCampeaoEntity.findByNomeTecnico(anyString()))
                .thenReturn(envio);

        TipoCampeao result = tipoCampeaoServiceImpl.biscaTipoCampeaoPorNomeTecnico("nomeTecnico");
        assertEquals(TipoCampeao.builder()
                .id(Long.valueOf(1))
                .nomeTecnico("nomeTecnico")
                .descricao("tipoCampeao")
                .build(),
                result);
    }


    @Test(expected = TipoCampeaoException.class)
    public void testBiscaTipoCampeaoPorNomeTecnicoComErro() throws Exception {
        when(repositorioTipoCampeaoEntity.findByNomeTecnico(anyString())).thenReturn(null);
        TipoCampeao result = tipoCampeaoServiceImpl.biscaTipoCampeaoPorNomeTecnico("nomeTecnico");
    }
}