package br.com.mentoria.servicos.contratos.impl;

import br.com.mentoria.bd.contratos.RepositorioCampeaoEntity;
import br.com.mentoria.bd.contratos.RepositorioTipoCampeaoEntity;
import br.com.mentoria.bd.entidades.CampeaoEntidade;
import br.com.mentoria.bd.entidades.TipoCampeaoEntidade;
import br.com.mentoria.servicos.entidades.Campeao;
import br.com.mentoria.servicos.entidades.TipoCampeao;
import br.com.mentoria.servicos.exececoes.CampeaoException;
import builders.CampeaoBuilder;
import builders.TipoCampeaoBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class CampeaoServicoImplTest {
    @Mock
    RepositorioCampeaoEntity campeaoRepositorio;
    @Mock
    RepositorioTipoCampeaoEntity repositorioTipoCampeaoEntity;
    @InjectMocks
    CampeaoServicoImpl campeaoServicoImpl;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSalvarCampeao() throws Exception {
        when(campeaoRepositorio.save(any()))
                .thenReturn(CampeaoBuilder.campeaoEntidadeBuilder());
        when(repositorioTipoCampeaoEntity.findByNomeTecnico(anyString()))
                .thenReturn(TipoCampeaoBuilder.tipoCampeaoEntidadeBuilder());
        boolean result = campeaoServicoImpl.salvarCampeao(CampeaoBuilder.campeaoBuilder());
        Assert.assertEquals(true, result);
    }


    @Test(expected = CampeaoException.class)
    public void testSalvarCampeaoErroTipo() throws Exception {
        when(campeaoRepositorio.save(any()))
                .thenReturn(CampeaoBuilder.campeaoEntidadeBuilder());
        TipoCampeaoEntidade entidadeRetorno = TipoCampeaoBuilder.tipoCampeaoEntidadeBuilder();
        entidadeRetorno.setTipoCampeao("ABC");
        when(repositorioTipoCampeaoEntity.findByNomeTecnico(anyString()))
                .thenReturn(entidadeRetorno);
        Campeao campeaoEnviado = CampeaoBuilder.campeaoBuilder();
        campeaoEnviado.setTipo(TipoCampeao.builder().nomeTecnico("abc").build());
        campeaoServicoImpl.salvarCampeao(campeaoEnviado);
    }

    @Test(expected = CampeaoException.class)
    public void testSalvarCampeaoErroValidacaoEmail() throws Exception {
        when(campeaoRepositorio.save(any()))
                .thenReturn(CampeaoBuilder.campeaoEntidadeBuilder());
        when(repositorioTipoCampeaoEntity.findByNomeTecnico(anyString()))
                .thenReturn(TipoCampeaoBuilder.tipoCampeaoEntidadeBuilder());
        Campeao campeaoEnviadoSalvar = CampeaoBuilder.campeaoBuilder();
        campeaoEnviadoSalvar.setEmail("abc");
        campeaoServicoImpl.salvarCampeao(campeaoEnviadoSalvar);
    }

    @Test(expected = CampeaoException.class)
    public void testSalvarCampeaoErroValidacaoNome() throws Exception {
        when(campeaoRepositorio.save(any()))
                .thenReturn(CampeaoBuilder.campeaoEntidadeBuilder());
        when(repositorioTipoCampeaoEntity.findByNomeTecnico(anyString()))
                .thenReturn(TipoCampeaoBuilder.tipoCampeaoEntidadeBuilder());
        Campeao campeaoEnviadoSalvar = CampeaoBuilder.campeaoBuilder();
        campeaoEnviadoSalvar.setNome("");
        campeaoServicoImpl.salvarCampeao(campeaoEnviadoSalvar);
    }

    @Test(expected = CampeaoException.class)
    public void testSalvarCampeaoErroValidacaoCorSabre() throws Exception {
        when(campeaoRepositorio.save(any()))
                .thenReturn(CampeaoBuilder.campeaoEntidadeBuilder());
        when(repositorioTipoCampeaoEntity.findByNomeTecnico(anyString()))
                .thenReturn(TipoCampeaoBuilder.tipoCampeaoEntidadeBuilder());
        Campeao campeaoEnviadoSalvar = CampeaoBuilder.campeaoBuilder();
        campeaoEnviadoSalvar.setCorSabre("");
        campeaoServicoImpl.salvarCampeao(campeaoEnviadoSalvar);
    }

    @Test
    public void testListarTodos() throws Exception {
        when(campeaoRepositorio.findAll())
                .thenReturn(Arrays.asList(CampeaoBuilder.campeaoEntidadeBuilder()));
        List<Campeao> result = campeaoServicoImpl.listarTodos();
        assertTrue(result.size() == 1);
    }

    @Test
    public void testEncotraCampeaoSucesso() throws Exception{
        when(campeaoRepositorio.findByEmail(anyString()))
                .thenReturn(CampeaoEntidade.builder().build());
        assertNotNull(campeaoServicoImpl.encotraCampeao("bananinha@banana.com"));
    }

}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme