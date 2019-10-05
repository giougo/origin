package com.prestador.saude.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class PrestadorResponseDTO {
	private String nome;
	private String endereco;
	private Double latitude;
	private Double longitude;
	private Double distanciaEmKm;
}
