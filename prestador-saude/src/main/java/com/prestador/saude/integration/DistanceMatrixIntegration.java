package com.prestador.saude.integration;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.prestador.saude.dto.matrixresponse.DistanceMatrixResponseDTO;
import com.prestador.saude.exception.DistanceMatrixException;
import com.prestador.saude.model.CoordenadaGeografica;
import com.prestador.saude.util.URLDistanceMatrixBuilder;
import com.prestador.saude.validation.DistanceMatrixResponseValidator;

@Component
public class DistanceMatrixIntegration {

	private static final String MENSAGEM_ERRO_OBTENCAO_DE_DISTANCIAS = "Retorno vazio na resposta da API de proximidade";
	
	@Autowired
	private Logger log;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private URLDistanceMatrixBuilder urlBuilder;
	
	@Autowired
	private DistanceMatrixResponseValidator validador;
	
	public DistanceMatrixResponseDTO getDistanciaParaPrestadores(CoordenadaGeografica origem, List<CoordenadaGeografica> destinos) {
		String url = this.urlBuilder.construirURLDistanceMatrix(origem, destinos);
		
		ResponseEntity<DistanceMatrixResponseDTO> distanciasRetornadas = getDistancias(url);
		
		if (distanciasRetornadas!= null) {
			validador.validarMatrixDistanceResponse(distanciasRetornadas.getBody());
			return distanciasRetornadas.getBody();
		} else {
			throw new DistanceMatrixException(MENSAGEM_ERRO_OBTENCAO_DE_DISTANCIAS);
		}
	}
	
	private ResponseEntity<DistanceMatrixResponseDTO> getDistancias(String url) {
		try {
			return this.restTemplate.getForEntity(url, DistanceMatrixResponseDTO.class);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new DistanceMatrixException(e.getMessage());
		}
	}
	
	
}
