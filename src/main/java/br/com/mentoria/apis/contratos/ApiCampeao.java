package br.com.mentoria.apis.contratos;

import br.com.mentoria.apis.entidades.CampeaoAPI;
import br.com.mentoria.apis.entidades.combate.RetornoCampeaoCombateAPI;
import br.com.mentoria.apis.entidades.combate.RetornoCombateAPI;
import br.com.mentoria.servicos.exececoes.CampeaoException;
import org.springframework.http.ResponseEntity;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.List;

public interface ApiCampeao {

    @ApiOperation(value = "Salvar um novo campeao")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna uma mensagem se salvou o valor"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 406, message = "Quando alguma das regras forem quebradas"),
            @ApiResponse(code = 500, message = "Retornara uma mensagem amigável para o usuário"),
    })
    ResponseEntity<CampeaoAPI> salvarCampeao(CampeaoAPI campeaoAPI) throws CampeaoException;


    @ApiOperation(value = "Listar todos os campeões")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna todos os capeões"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Retornara uma mensagem amigável para o usuário"),
    })
    ResponseEntity<List<CampeaoAPI>> listarCampeao() throws CampeaoException;


    @ApiOperation(value = "Retorna o campeão com base no email informa")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna o capeão"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Retornara uma mensagem amigável para o usuário"),
    })
    ResponseEntity<CampeaoAPI> retornaCampeao(String email) throws CampeaoException;


    @ApiOperation(value = "Retorna os campeões que iram combater")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna o capeão"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Retornara uma mensagem amigável para o usuário"),
    })
    ResponseEntity<RetornoCombateAPI> retornaCombatentes(String emailSolicitanteCombate);
}
