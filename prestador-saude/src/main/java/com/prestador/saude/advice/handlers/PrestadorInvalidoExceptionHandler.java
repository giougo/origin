package com.prestador.saude.advice.handlers;

import org.springframework.stereotype.Component;

import com.prestador.saude.dto.ErrorResponseDTO;
import com.prestador.saude.exception.PrestadorInvalidoException;

@Component
public class PrestadorInvalidoExceptionHandler {

	public ErrorResponseDTO tratarPrestadorInvalido(PrestadorInvalidoException exception) {
		return ErrorResponseDTO.builder()
				.mensagem(exception.getMessage())
				.erros(exception.getErros())
				.build();
	}
}
