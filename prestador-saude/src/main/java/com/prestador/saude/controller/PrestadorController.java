package com.prestador.saude.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prestador.saude.dto.PrestadorResponseDTO;
import com.prestador.saude.service.PrestadorService;

@RestController("prestador_controller")
@RequestMapping(CorrelationController.PRESTADOR_PATH)
public class PrestadorController extends CorrelationController {
	
	@Autowired
	private PrestadorService prestadorService;

	@RequestMapping(method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<PrestadorResponseDTO> obterPrestadoresSaude(
			@RequestParam(name = "latitude") Double latitude,
			@RequestParam(name = "longitude") Double longitude,
			@RequestParam(name = "especialidade") String especialidade
	) {
		return this.prestadorService.getPrestadores(latitude, longitude, especialidade);
	}
}
