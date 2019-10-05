package com.prestador.saude.mock;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.prestador.saude.model.CoordenadaGeografica;
import com.prestador.saude.model.Prestador;

@Component
public class MockFactory {

	private MockFactory() {};
	
	public static MockFactory getMockFactory() {
		return new MockFactory();
	}
	
	private static double i = 0;
	
	private void somarIndice() {
		i+=0.0001;
	}
	
	public Prestador getPrestadorMock() {
		CoordenadaGeografica localizacaoMock = getCoordenadaGeograficaMock();
		List<String> especialidadesDoPrestadorMock = getEspecialidadesPrestadorMock();
		
		Prestador prestadorMock = Prestador.builder()
			.nome(UUID.randomUUID().toString())
			.endereco(UUID.randomUUID().toString())
			.especialidades(especialidadesDoPrestadorMock)
			.localizacao(localizacaoMock)
			.build();
		
		return prestadorMock;
	}
	
	public CoordenadaGeografica getCoordenadaGeograficaMock() {
		somarIndice();
		CoordenadaGeografica localizacaoMock = CoordenadaGeografica.builder()
			.latidude(-23.5629 + i)
			.longitude(-46.6544 + i)
			.build();
		
		return localizacaoMock;
	}
	
	public List<String> getEspecialidadesPrestadorMock() {
		List<String> listaEspecialidades = List.of("cardiologia", "dermatologia", "oftalmologia");
		List<String> especialidadesDoPrestador = new ArrayList<>(listaEspecialidades.size());
		
		listaEspecialidades.forEach(especialidade -> {
			boolean coinFlip = new Random().nextBoolean();
			if (coinFlip) {
				especialidadesDoPrestador.add(especialidade);
			}
		});
		
		if (especialidadesDoPrestador.isEmpty()) {
			int indiceEspecialidadeAleatorio = new Random().nextInt(listaEspecialidades.size());
			String especialidadeAleatoria = listaEspecialidades.get(indiceEspecialidadeAleatorio);
			especialidadesDoPrestador.add(especialidadeAleatoria);
		}
		
		return especialidadesDoPrestador;
	}
	
	public List<Prestador> getPrestadoresMock(int quantidadeDePrestadores) {
		List<Prestador> prestadoresMock = new ArrayList<>(quantidadeDePrestadores);
		
		for (int i = 0; i < quantidadeDePrestadores; i++) {
			prestadoresMock.add(getPrestadorMock());
		}
		
		return prestadoresMock;
	}
}
