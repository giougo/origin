package com.prestador.saude.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

public class CorrelationController {

	public static final String CONTEXT_PATH = "/";
	public static final String PRESTADOR_PATH = CONTEXT_PATH + "prestador";
	
	@Autowired
	private HttpServletRequest httpServletRequest;
	
	protected HttpServletRequest getHttpServletRequest() {
		return httpServletRequest;
	}
}

