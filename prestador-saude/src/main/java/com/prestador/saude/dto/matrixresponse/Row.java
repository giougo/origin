package com.prestador.saude.dto.matrixresponse;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Row {
	
	private static final String MENSAGEM_ELEMENTOS_DE_LINHA_DE_ENDERECO_VAZIO = "Elementos de linha de endereco vazio";
	
	@Valid
	@NotNull(message = MENSAGEM_ELEMENTOS_DE_LINHA_DE_ENDERECO_VAZIO)
	@NotEmpty(message = MENSAGEM_ELEMENTOS_DE_LINHA_DE_ENDERECO_VAZIO)
	private Element[] elements;
}

