package com.prestador.saude.advice.handlers;

import org.springframework.stereotype.Component;

import com.prestador.saude.dto.ErrorResponseDTO;
import com.prestador.saude.exception.DistanceMatrixException;

@Component
public class DistanceMatrixExceptionHandler {
	
	public ErrorResponseDTO tratarDistanceMatrixException(DistanceMatrixException exception) {
		return ErrorResponseDTO.builder()
			.mensagem(exception.getMessage())
			.erros(exception.getErros())
			.build();
	}

}
