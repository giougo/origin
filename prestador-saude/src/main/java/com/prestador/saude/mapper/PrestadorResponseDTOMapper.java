package com.prestador.saude.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.prestador.saude.dto.PrestadorResponseDTO;
import com.prestador.saude.model.Prestador;

@Component
public class PrestadorResponseDTOMapper {
	
	public List<PrestadorResponseDTO> mapearPrestadores(List<Prestador> prestadores) {
		return prestadores.stream().map(prestador -> mapearPrestador(prestador)).collect(Collectors.toList());
	}
	
	public PrestadorResponseDTO mapearPrestador(Prestador prestador) {
		return PrestadorResponseDTO.builder()
				.nome(prestador.getNome())
				.endereco(prestador.getEndereco())
				.latitude(prestador.getLocalizacao().getLatidude())
				.longitude(prestador.getLocalizacao().getLongitude())
				.distanciaEmKm(prestador.getDistanciaEmKm())
				.build(); 
	}
}
