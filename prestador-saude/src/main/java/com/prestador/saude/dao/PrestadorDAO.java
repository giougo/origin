package com.prestador.saude.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.prestador.saude.model.Prestador;
import com.prestador.saude.repository.PrestadorRepository;

@Repository
public class PrestadorDAO {
	
	@Autowired
	private PrestadorRepository repository;
	
	public List<Prestador> getPrestadoresByEspecialidade(String especialidade) {
		return this.repository.getPrestadoresByEspecialidade(especialidade);
	}
}
