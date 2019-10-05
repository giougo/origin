package com.prestador.saude.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class CoordenadaGeografica {
	private Double latidude;
	private Double longitude;
}
