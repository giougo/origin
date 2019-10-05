package com.prestador.saude.util;

import java.util.Set;

import javax.validation.ConstraintViolation;

import org.springframework.stereotype.Component;

import com.prestador.saude.dto.Erro;

@Component
public class ErroBuilder {
	
	public <T> Erro[] construirErros(Set<ConstraintViolation<T>> violations) {
		Erro[] erros = violations.stream().map(violacao -> {
			Erro erro = new Erro();
			erro.setDescricao(violacao.getMessage());
			erro.setValor(violacao.getInvalidValue());
			return erro;
		}).toArray(Erro[]::new);

		return erros;
	}
}
