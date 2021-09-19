package br.com.mentoria.apis.contratos.impl;

import br.com.mentoria.adaptadores.CapeaoServiceAdpter;
import br.com.mentoria.apis.contratos.ApiCampeao;
import br.com.mentoria.apis.entidades.NovoCampeaoDTO;
import br.com.mentoria.servicos.contratos.CampeaoServico;
import br.com.mentoria.servicos.entidades.Campeao;
import br.com.mentoria.servicos.exececoes.CampeaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/capeao")
public class ApiCampeaoImpl implements ApiCampeao {

	private CampeaoServico campeaoServico;

	@Autowired
	public ApiCampeaoImpl(CampeaoServico campeaoServico){
		this.campeaoServico = campeaoServico;
	}


	@PostMapping(value = "/savar")
	@Override
	public ResponseEntity<NovoCampeaoDTO> salvarCampeao(@RequestBody NovoCampeaoDTO novoCampeao) throws CampeaoException {
		CapeaoServiceAdpter adpter = new CapeaoServiceAdpter(novoCampeao);
		campeaoServico.salvarCampeao(adpter.getCampeao());
		return ResponseEntity.ok(novoCampeao);
	}
}
