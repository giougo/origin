package com.prestador.saude.dto.matrixresponse;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Element {

	private static final String MENSAGEM_DISTANCIA_VAZIA = "Dados de distancia do prestador vazios";

	@Valid
	@NotNull(message = MENSAGEM_DISTANCIA_VAZIA)
	private Distance distance;
	private Duration duration;
	private String status;
}
