package com.prestador.saude.service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prestador.saude.model.CoordenadaGeografica;
import com.prestador.saude.model.Prestador;

@Service
public class OrdenacaoPrestadorService {
	
	@Autowired
	private DistanciaPrestadorService distanciaService;
	
	public List<Prestador> ordenarPrestadoresPorProximidade(CoordenadaGeografica origem, List<Prestador> prestadores) {
		Map<Double, List<Prestador>> mapaDeDistanciaPorPrestador = this.distanciaService.getMapaDeProximidadeDePrestadores(origem, prestadores);
		
		List<Prestador> prestadoresOrdenadosPorProximidade = ordenarPrestadoresPorProximidade(mapaDeDistanciaPorPrestador);
		
		return prestadoresOrdenadosPorProximidade;
	}

	private List<Prestador> ordenarPrestadoresPorProximidade(Map<Double, List<Prestador>> mapaDeDistanciaPorPrestador) {
		List<Prestador> prestadoresOrdenadosPorMenorDistancia = mapaDeDistanciaPorPrestador
				.entrySet()
				.stream()
				.sorted(Comparator.comparingDouble(Entry::getKey))
				.map(entry -> entry.getValue())
				.flatMap(listaPrestadores -> listaPrestadores.stream())
				.collect(Collectors.toList());
		
		return prestadoresOrdenadosPorMenorDistancia;
	}
}
