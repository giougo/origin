package com.prestador.saude.advice.handlers;

import org.springframework.stereotype.Component;

import com.prestador.saude.dto.ErrorResponseDTO;
import com.prestador.saude.exception.EntidadeNaoEncontradaException;

@Component
public class EntidadeNaoEncontradaExceptionHandler {
	
	public ErrorResponseDTO tratarEntidadeNaoEncontrada(EntidadeNaoEncontradaException exception) {
		return ErrorResponseDTO.builder()
			.mensagem(exception.getMessage())
			.build();
	}

}
