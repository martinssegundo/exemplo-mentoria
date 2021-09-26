package br.com.mentoria.apis.contratos.impl;

import br.com.mentoria.adaptadores.CampeaoAPIAdapter;
import br.com.mentoria.adaptadores.CapeaoServiceAdpter;
import br.com.mentoria.apis.contratos.ApiCampeao;
import br.com.mentoria.apis.entidades.CampeaoAPI;
import br.com.mentoria.servicos.contratos.CampeaoServico;
import br.com.mentoria.servicos.exececoes.CampeaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
	public ResponseEntity<CampeaoAPI> salvarCampeao(@RequestBody CampeaoAPI campeaoAPI) throws CampeaoException {
		CapeaoServiceAdpter adpter = new CapeaoServiceAdpter(campeaoAPI);
		campeaoServico.salvarCampeao(adpter.getCampeao());
		return ResponseEntity.ok(campeaoAPI);
	}

	@GetMapping(value = "/listar")
	@Override
	public ResponseEntity<List<CampeaoAPI>> listarCampeao() throws CampeaoException {
		return ResponseEntity.ok(new CampeaoAPIAdapter(campeaoServico.listarTodos()).getCampeaoAPIS());
	}
}
