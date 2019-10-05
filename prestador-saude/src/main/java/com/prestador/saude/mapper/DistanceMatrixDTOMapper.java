package com.prestador.saude.mapper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.prestador.saude.dto.matrixresponse.DistanceMatrixResponseDTO;
import com.prestador.saude.dto.matrixresponse.Element;
import com.prestador.saude.dto.matrixresponse.Row;
import com.prestador.saude.model.Prestador;

@Service
public class DistanceMatrixDTOMapper {

	public Map<Double, List<Prestador>> mapearParaProximidadeComPrestadores(DistanceMatrixResponseDTO dto, List<Prestador> prestadores) {

		Map<Double, List<Prestador>> mapaDeProximidadeDePrestadores = extrairMapaDeProximidade(dto.getRows(), prestadores);

		return mapaDeProximidadeDePrestadores;
	}
	
	private Map<Double, List<Prestador>> extrairMapaDeProximidade(Row[] rows, List<Prestador> prestadores) {

		Map<Double, List<Prestador>> mapaDeProximidadeDePrestadores = new HashMap<>();
		Iterator<Prestador> prestadorIterator = prestadores.iterator();

		List<Row> linhas = Arrays.asList(rows);
		
		linhas.forEach(linha -> {
			
			List<Element> elementos = Arrays.asList(linha.getElements());
			elementos.forEach(elemento -> {
				
				Double distanciaEmKm = extrairDistanciaDeElemento(elemento);
				Prestador prestador = prestadorIterator.next();
				prestador.setDistanciaEmKm(distanciaEmKm);

				mapaDeProximidadeDePrestadores
					.computeIfAbsent(distanciaEmKm, (n) -> new ArrayList<Prestador>()).add(prestador);
			});
		});
		
		return mapaDeProximidadeDePrestadores;
	}

	private Double extrairDistanciaDeElemento(Element elemento) {
		String distanciaDeElemento = elemento.getDistance().getText();
		Double distanciaEmKm = extrairDistanciaEmKm(distanciaDeElemento);
		
		return distanciaEmKm;
	}
	
	private Double extrairDistanciaEmKm(String distancia) {
		if (distancia.contains(" m")) {
			return extrairDistanciaNumericaDeMetrosParaKm(distancia);
		}
		return extrairDistanciaNumericaEmKm(distancia);
	}
	
	private Double extrairDistanciaNumericaDeMetrosParaKm(String distanciaEmMetros) {
		distanciaEmMetros = distanciaEmMetros.replaceAll(" ", "");
		distanciaEmMetros = distanciaEmMetros.replaceAll("m", "");
		Double distanciaEmKmNumerica = Double.parseDouble(distanciaEmMetros);
		return distanciaEmKmNumerica / 1000;
	}
	
	private Double extrairDistanciaNumericaEmKm(String distanciaEmKm) {
		distanciaEmKm = distanciaEmKm.replaceAll(" ", "");
		distanciaEmKm = distanciaEmKm.replaceAll("km", "");
		Double distanciaEmKmNumerica = Double.parseDouble(distanciaEmKm);
		return distanciaEmKmNumerica;
	}
	
}
