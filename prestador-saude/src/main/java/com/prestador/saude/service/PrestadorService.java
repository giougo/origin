package com.prestador.saude.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prestador.saude.dao.PrestadorDAO;
import com.prestador.saude.dto.PrestadorResponseDTO;
import com.prestador.saude.exception.EntidadeNaoEncontradaException;
import com.prestador.saude.mapper.PrestadorResponseDTOMapper;
import com.prestador.saude.model.CoordenadaGeografica;
import com.prestador.saude.model.Prestador;

@Service
public class PrestadorService {
	
	private static final String MENSAGEM_ESPECIALIDADE_NAO_ENCONTRADA = "Prestadores com esta especialidade nao foram encontrados";
	
	@Autowired
	private OrdenacaoPrestadorService ordenacaoPrestadorService;
	
	@Autowired
	private PrestadorResponseDTOMapper prestadorResponseDTOMapper;
	
	@Autowired
	private PrestadorDAO prestadorDAO;
	
	public List<PrestadorResponseDTO> getPrestadores(Double latitude, Double longitude, String especialidade) {
		CoordenadaGeografica origem = CoordenadaGeografica.builder().latidude(latitude).longitude(longitude).build();
		
		List<Prestador> prestadores = getPrestadoresByEspecialidade(especialidade);
		
		List<Prestador> prestadoresOrdenados = this.ordenacaoPrestadorService.ordenarPrestadoresPorProximidade(origem, prestadores);
		
		List<PrestadorResponseDTO> dtoPrestadores = this.prestadorResponseDTOMapper.mapearPrestadores(prestadoresOrdenados);

		return dtoPrestadores;
	}
	
	public List<Prestador> getPrestadoresByEspecialidade(String especialidade) {
		List<Prestador> prestadores = this.prestadorDAO.getPrestadoresByEspecialidade(especialidade);
		
		if(prestadores.isEmpty()) {
			throw new EntidadeNaoEncontradaException(MENSAGEM_ESPECIALIDADE_NAO_ENCONTRADA);
		}
		
		return prestadores;
	}
}