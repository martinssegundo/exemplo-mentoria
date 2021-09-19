package br.com.skeleton.apis.impl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.skeleton.apis.ApiExemplo;

@RestController
@RequestMapping(path = "/api")
public class ApiExemploImpl implements ApiExemplo{
	
	@PostMapping(value = "/save")
	@Override
	public ResponseEntity<String> save(@RequestBody String savedValue) {
		System.out.println("Salvou o valor:"+savedValue);
		return new ResponseEntity<>("Valor salvo com sucesso",HttpStatus.OK);
	}

}
