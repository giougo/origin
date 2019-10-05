package com.prestador.saude.validation;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.prestador.saude.dto.Erro;
import com.prestador.saude.dto.matrixresponse.DistanceMatrixResponseDTO;
import com.prestador.saude.exception.DistanceMatrixException;
import com.prestador.saude.util.ErroBuilder;

@Component
public class DistanceMatrixResponseValidator {
	
	private static final String MENSAGEM_ERRO_PRESTADOR_INVALIDO = "Resposta da API de proximidade invalida";
	
	private static final Validator validator;

	static {
		validator = Validation.buildDefaultValidatorFactory().getValidator();
	}
	
	@Autowired
	private ErroBuilder erroBuilder;

	public void validarMatrixDistanceResponse(DistanceMatrixResponseDTO dto) {
		Set<ConstraintViolation<DistanceMatrixResponseDTO>> violations = validator.validate(dto);
		
		if (violations.size() > 0) {
			Erro[] errosDeValidacao = this.erroBuilder.construirErros(violations);
			throw new DistanceMatrixException(MENSAGEM_ERRO_PRESTADOR_INVALIDO, errosDeValidacao);
		}
	}
}
