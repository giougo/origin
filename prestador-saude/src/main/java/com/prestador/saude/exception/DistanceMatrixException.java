package com.prestador.saude.exception;

import com.prestador.saude.dto.Erro;

public class DistanceMatrixException extends RuntimeException {

	private static final long serialVersionUID = -6731678168535567882L;
	
	private Erro[] erros;
	
	public DistanceMatrixException(String mensagemDeErro, Erro[] erros) {
		super(mensagemDeErro);
		this.erros = erros;
	}
	
	public DistanceMatrixException(String mensagemDeErro) {
		super(mensagemDeErro);
		this.erros = new Erro[0];
	}

	public Erro[] getErros() {
		return this.erros;
	}
}
