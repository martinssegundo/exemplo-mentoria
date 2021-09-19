package br.com.mentoria.apis.contratos;

import br.com.mentoria.apis.entidades.NovoCampeaoDTO;
import br.com.mentoria.servicos.exececoes.CampeaoException;
import org.springframework.http.ResponseEntity;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

public interface ApiCampeao {
	
	@ApiOperation(value = "Salvar um novo campeao")
	@ApiResponses(value = {
	    @ApiResponse(code = 200, message = "Retorna uma mensagem se salvou o valor"),
	    @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
	    @ApiResponse(code = 500, message = "Retornara uma mensagem amigável para o usuária"),
	})	
	ResponseEntity<NovoCampeaoDTO> salvarCampeao(NovoCampeaoDTO novoCampeao) throws CampeaoException;

}
