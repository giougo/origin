package com.prestador.saude.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ErrorResponseDTO {

	private String mensagem;
	@Builder.Default
	private Erro[] erros = new Erro[0];
}
