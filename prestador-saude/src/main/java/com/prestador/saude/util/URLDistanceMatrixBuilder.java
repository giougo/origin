package com.prestador.saude.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.prestador.saude.model.CoordenadaGeografica;

@Component
public class URLDistanceMatrixBuilder {
	
	private static String URL_SERVICO_DISTANCIA;
	private static String API_KEY;
	
	@Value("${url.servico.distancia}")
	public void setUrlServicoDistancia(String url) {
		URL_SERVICO_DISTANCIA = url;
	}
	
	@Value("${google.distance.matrix.key}")
	public void setApiKey(String apiKey) {
		API_KEY = apiKey;
	}
	
	public String construirURLDistanceMatrix(CoordenadaGeografica origem, List<CoordenadaGeografica> destinos) {
		String parametrosUrlDestinos = construirDestinos(destinos);
		String parametroUrlOrigem = construirOrigem(origem);

		String url = String.format(URL_SERVICO_DISTANCIA, parametroUrlOrigem, parametrosUrlDestinos, API_KEY);
		
		return url;
	}
	
	private String construirOrigem(CoordenadaGeografica origem) {
		return new StringBuilder(origem.getLatidude() + "").append(",").append(origem.getLongitude() + "").toString();
	}

	private String construirDestinos(List<CoordenadaGeografica> destinos) {
		StringBuilder sb = new StringBuilder();

		destinos.forEach(destino -> {
			sb.append(destino.getLatidude()).
			append(",").
			append(destino.getLongitude()).
			append("|");
		});
		
		int tamanhoStringDestinos = sb.toString().length();
		
		String destinosFormatados = sb.toString().substring(0, tamanhoStringDestinos -1);
		
		return destinosFormatados;
	}
}
