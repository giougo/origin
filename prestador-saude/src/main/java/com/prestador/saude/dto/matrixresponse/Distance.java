package com.prestador.saude.dto.matrixresponse;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Distance {
	
	private static final String MENSAGEM_DISTANCIA_VAZIA = "Dados de distancia do prestador vazios";
	
	@NotNull(message = MENSAGEM_DISTANCIA_VAZIA)
	private String text;
	private int value;
}