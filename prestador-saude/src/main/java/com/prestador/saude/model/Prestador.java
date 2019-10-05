package com.prestador.saude.model;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
public class Prestador {
	
	private static final String MENSAGEM_ERRO_NOME_NULO = "Nao ha nome cadastrado para o prestador";
	private static final String MENSAGEM_ERRO_NOME_INCOMPLETO = "Necessario o cadastro do nome completo do prestador";
	private static final String MENSAGEM_ERRO_ESPECIALIDADE_NULA = "Especialidade nao cadastrada para o prestador";
	private static final String MENSAGEM_ERRO_ENDERECO_NAO_CADASTRADO = "Endereco do prestador nao esta cadastrado";
	private static final String MENSAGEM_LOCALIZACAO_NAO_CADASTRADA = "Localizacao do prestador nao esta cadastrada";
	
	@NotNull(message = MENSAGEM_ERRO_NOME_NULO)
	@Length(min = 1, message = MENSAGEM_ERRO_NOME_INCOMPLETO)
	private String nome;
	
	@NotNull(message = MENSAGEM_ERRO_ENDERECO_NAO_CADASTRADO)
	private String endereco;
	
	@NotNull(message = MENSAGEM_ERRO_ESPECIALIDADE_NULA)
	private List<String> especialidades;
	
	@NotNull(message = MENSAGEM_LOCALIZACAO_NAO_CADASTRADA)
	private CoordenadaGeografica localizacao;
	
	private Double distanciaEmKm;
	
	public void setDistanciaEmKm(Double distanciaEmKm) {
		this.distanciaEmKm = distanciaEmKm;
	}
}
