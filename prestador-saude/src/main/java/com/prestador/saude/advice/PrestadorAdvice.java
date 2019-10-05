package com.prestador.saude.advice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.prestador.saude.advice.handlers.DistanceMatrixExceptionHandler;
import com.prestador.saude.advice.handlers.EntidadeNaoEncontradaExceptionHandler;
import com.prestador.saude.advice.handlers.ErroDesconhecidoExceptionHandler;
import com.prestador.saude.advice.handlers.PrestadorInvalidoExceptionHandler;
import com.prestador.saude.dto.ErrorResponseDTO;
import com.prestador.saude.exception.DistanceMatrixException;
import com.prestador.saude.exception.EntidadeNaoEncontradaException;
import com.prestador.saude.exception.PrestadorInvalidoException;

@RestControllerAdvice
public class PrestadorAdvice {
	
	@Autowired
	private PrestadorInvalidoExceptionHandler prestadorInvalidoExceptionHandler;

	@Autowired
	private EntidadeNaoEncontradaExceptionHandler entidadeNaoEncontradaHandler;
	
	@Autowired
	private ErroDesconhecidoExceptionHandler erroDesconhecidoHandler;
	
	@Autowired
	private DistanceMatrixExceptionHandler matrixDistanceHandler;
	
	@ExceptionHandler(PrestadorInvalidoException.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorResponseDTO processarPrestadorInvalido(PrestadorInvalidoException exception) {
		ErrorResponseDTO message = this.prestadorInvalidoExceptionHandler.tratarPrestadorInvalido(exception);
		return message;
	}
	
	@ExceptionHandler(EntidadeNaoEncontradaException.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorResponseDTO processarEntidadeNaoEncontrada(EntidadeNaoEncontradaException exception) {
		ErrorResponseDTO message = this.entidadeNaoEncontradaHandler.tratarEntidadeNaoEncontrada(exception);
		return message;
	}
	
	@ExceptionHandler(DistanceMatrixException.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.BAD_GATEWAY)
	public ErrorResponseDTO processarErroResponseDistanceMatrix(DistanceMatrixException exception) {
		ErrorResponseDTO message = this.matrixDistanceHandler.tratarDistanceMatrixException(exception);
		return message;
	}
	
	@ExceptionHandler(Exception.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ErrorResponseDTO processarErroDesconhecido(EntidadeNaoEncontradaException exception) {
		ErrorResponseDTO message = this.erroDesconhecidoHandler.tratarErroDesconhecido(exception);
		return message;
	}
}
