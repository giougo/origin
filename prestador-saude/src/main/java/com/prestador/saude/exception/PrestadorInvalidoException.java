package com.prestador.saude.exception;

import com.prestador.saude.dto.Erro;

public class PrestadorInvalidoException extends RuntimeException {

	private static final long serialVersionUID = -3239991714023712285L;
	
	private Erro[] erros;
	
	public PrestadorInvalidoException(String mensagemDeErro, Erro[] erros) {
		super(mensagemDeErro);
		this.erros = erros;
	}

	public Erro[] getErros() {
		return this.erros;
	}
}
