package br.com.mentoria.apis.contratos.impl;

import br.com.mentoria.adaptadores.campeao.CampeaoAPIAdapter;
import br.com.mentoria.adaptadores.campeao.CapeaoServiceAdpter;
import br.com.mentoria.apis.contratos.ApiCampeao;
import br.com.mentoria.apis.entidades.CampeaoAPI;
import br.com.mentoria.servicos.contratos.CampeaoServico;
import br.com.mentoria.servicos.exececoes.CampeaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
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
		try{
			campeaoServico.salvarCampeao(adpter.getCampeao());
		}catch (CampeaoException exception){
			return ResponseEntity.status(406).body(CampeaoAPI.builder()
					.erro(exception.getMessage())
					.build());
		}
		return ResponseEntity.ok(campeaoAPI);
	}

	@GetMapping(value = "/listar")
	@Override
	public ResponseEntity<List<CampeaoAPI>> listarCampeao() throws CampeaoException {
		return ResponseEntity.ok(new CampeaoAPIAdapter(campeaoServico.listarTodos()).getCampeaoAPIS());
	}

	@GetMapping(value = "/encotrar/{email}")
	@Override
	public ResponseEntity<CampeaoAPI> retornaCampeao(@PathVariable String email) throws CampeaoException {
		CampeaoAPI campeaoRetornado =
				new CampeaoAPIAdapter(campeaoServico.encotraCampeao(email)).getCampeaoAPI();
		return ResponseEntity.ok(campeaoRetornado);
	}
}
