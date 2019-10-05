package com.prestador.saude.dto.matrixresponse;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DistanceMatrixResponseDTO {
	
	private static final String MENSAGEM_ENDERECOS_DE_ORIGEM_VAZIO = "Enderecos de origem vazio";
	private static final String MENSAGEM_ENDERECOS_DE_DESTINO_VAZIO = "Enderecos de destino vazio";
	private static final String MENSAGEM_ROWS_DE_ENDERECO_VAZIO = "Linhas de endereco vazias";
	
	@NotNull(message = MENSAGEM_ENDERECOS_DE_DESTINO_VAZIO)
	@NotEmpty(message = MENSAGEM_ENDERECOS_DE_DESTINO_VAZIO)
	private String[] destination_addresses;
	
	@NotNull(message = MENSAGEM_ENDERECOS_DE_ORIGEM_VAZIO)
	@NotEmpty(message = MENSAGEM_ENDERECOS_DE_ORIGEM_VAZIO)
	private String[] origin_addresses;
	
	@NotNull(message = MENSAGEM_ROWS_DE_ENDERECO_VAZIO)
	@NotEmpty(message = MENSAGEM_ROWS_DE_ENDERECO_VAZIO)
	@Valid
	private Row[] rows;
	
	private String status;
}