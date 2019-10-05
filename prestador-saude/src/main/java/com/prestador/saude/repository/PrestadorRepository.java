package com.prestador.saude.repository;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.prestador.saude.mock.MockFactory;
import com.prestador.saude.model.Prestador;

@Repository
public class PrestadorRepository {
	
	private final static MockFactory mockFactory = MockFactory.getMockFactory();
	
	private final static List<Prestador> prestadoresDatabaseMock;
	
	static {
		prestadoresDatabaseMock = mockFactory.getPrestadoresMock(20);
	}
	
	public List<Prestador> getPrestadoresByEspecialidade(String especialidade) {
		List<Prestador> prestadores = prestadoresDatabaseMock
			.stream()
			.filter(prestador -> prestador.getEspecialidades().contains(especialidade))
			.collect(Collectors.toList());
		
		return prestadores;
	}
}
