package com.prestador.saude.validation;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.prestador.saude.dto.Erro;
import com.prestador.saude.exception.PrestadorInvalidoException;
import com.prestador.saude.model.Prestador;
import com.prestador.saude.util.ErroBuilder;

public class PrestadorValidator {
	
	private static final String MENSAGEM_ERRO_PRESTADOR_INVALIDO = "Prestador invalido";
	
	private static final Validator validator;

	static {
		validator = Validation.buildDefaultValidatorFactory().getValidator();
	}
	
	@Autowired
	private ErroBuilder erroBuilder;

	public void validarPrestador(Prestador prestador) throws JsonProcessingException {
		Set<ConstraintViolation<Prestador>> violations = validator.validate(prestador);

		if (violations.size() > 0) {
			Erro[] errosDeValidacao = this.erroBuilder.construirErros(violations);
			throw new PrestadorInvalidoException(MENSAGEM_ERRO_PRESTADOR_INVALIDO, errosDeValidacao);
		}
	}
}

