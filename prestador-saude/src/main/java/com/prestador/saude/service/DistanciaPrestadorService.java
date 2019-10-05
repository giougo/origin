package com.prestador.saude.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prestador.saude.dto.matrixresponse.DistanceMatrixResponseDTO;
import com.prestador.saude.integration.DistanceMatrixIntegration;
import com.prestador.saude.mapper.DistanceMatrixDTOMapper;
import com.prestador.saude.model.CoordenadaGeografica;
import com.prestador.saude.model.Prestador;

@Service
public class DistanciaPrestadorService {
	
	@Autowired
	private	DistanceMatrixIntegration distanceMatrixIntegration;
	
	@Autowired
	private DistanceMatrixDTOMapper mapper;

	public Map<Double, List<Prestador>> getMapaDeProximidadeDePrestadores(CoordenadaGeografica origem, List<Prestador> prestadores) {
		List<CoordenadaGeografica> localizacoes = extrairLocalizacaoDePrestadores(prestadores);
		
		DistanceMatrixResponseDTO responseDistancias = distanceMatrixIntegration.getDistanciaParaPrestadores(origem, localizacoes);
		
		Map<Double, List<Prestador>> mapaDeProximidadeDePrestadores = 
				this.mapper.mapearParaProximidadeComPrestadores(responseDistancias, prestadores);
	
		return mapaDeProximidadeDePrestadores;
	}
	
	private List<CoordenadaGeografica> extrairLocalizacaoDePrestadores(Collection<Prestador> prestadores) {
		List<CoordenadaGeografica> localizacoes = new ArrayList<>(prestadores.size());
		
		for(Prestador prestador: prestadores) {
			localizacoes.add(prestador.getLocalizacao());
		}
		
		return localizacoes;
	}
}
