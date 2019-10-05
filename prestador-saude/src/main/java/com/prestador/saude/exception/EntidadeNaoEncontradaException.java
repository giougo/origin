package com.prestador.saude.exception;

public class EntidadeNaoEncontradaException extends RuntimeException {

	private static final long serialVersionUID = 6346275489401032783L;
	
	public EntidadeNaoEncontradaException(String mensagemDeErro) {
		super(mensagemDeErro);
	}
}
