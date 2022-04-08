package com.example.lourdes.superheroes.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.lourdes.superheroes.model.SuperHeroe;
import com.example.lourdes.superheroes.repository.SuperHeroeRepository;
import com.example.lourdes.superheroes.service.impl.SuperHeroeServiceImpl;

@ExtendWith(MockitoExtension.class)
public class SuperHeroeServiceTest{

	@InjectMocks
	SuperHeroeServiceImpl superHeroeService;
	
	@Mock
	SuperHeroeRepository repository;
	
	private Map<Integer, SuperHeroe> superHeroes;
	private Integer id;
	private String nombre;
	private String estado;
	private SuperHeroe superHeroeEsperado;
	private SuperHeroe superHeroeActual;
	private List<SuperHeroe> superHeroesEsperado;
	private List<SuperHeroe> superHeroesEsperado2;
	private List<SuperHeroe> superHeroesActual;
	
	@BeforeEach
	void setup_test() {
		superHeroes = new HashMap<>();
		superHeroes.put(1,
				new SuperHeroe(1,"Superman", "Sano"));
		superHeroes.put(2,
				new SuperHeroe(2,"Batman", "Muerto"));
		
		//Inicializar variables
		id = Integer.valueOf(1);
		superHeroeEsperado = superHeroes.get(1);
		nombre = "man";
		superHeroesEsperado=List.of(superHeroes.get(1), superHeroes.get(2));
		superHeroesEsperado2=List.of(superHeroes.get(1));
		estado = "Sano";
	}	
	
	@Test
	void test_listarSuperHeroes() {
		//Comportamiento esperado del cuerpo del metodo
		when(repository.findAll()).thenReturn(superHeroesEsperado);
		
		//llamada al metodo a testear
		superHeroesActual = superHeroeService.listarSuperHeroes();
		
		//Comprobaciones del resultado esperado
		assertEquals(superHeroesActual.size(), superHeroesEsperado.size());
	}
	
	@Test
	void test_obtenerSuperHeore(){
		//Comportamiento esperado del cuerpo del metodo
		when(repository.findById(id)).thenReturn(Optional.of(superHeroeEsperado));
				
		//llamada al metodo a testear
		superHeroeActual = superHeroeService.obtenerSuperHeroe(id);
		
		//Comprobaciones del resultado esperado
		assertNotNull(superHeroeActual);
		assertEquals(id,superHeroeActual.getId());
		
	}

	@Test
	void test_buscarPorNombre() {
		//Comportamiento esperado del cuerpo del metodo
		when(repository.findByNombreContainingIgnoreCase(nombre)).thenReturn(superHeroesEsperado);
		
		//llamada al metodo a testear
		superHeroesActual = superHeroeService.buscarPorNombre(nombre);
		
		//Comprobaciones del resultado esperado
		assertEquals(superHeroesActual.size(), superHeroesEsperado.size());
		assertNotNull(superHeroesActual);
	}
	
	@Test
	void test_buscarPorEstado() {
		
		//Comportamiento esperado del cuerpo del metodo
		when(repository.findByEstado(estado)).thenReturn(superHeroesEsperado2);
	
		//llamada al metodo a testear
		superHeroesActual = superHeroeService.buscarPorEstado(estado);
		
		//Comprobaciones del resultado esperado
		assertEquals(superHeroesActual.size(), superHeroesEsperado2.size());
		assertEquals(superHeroesActual.get(0).getEstado(), estado);
	}
	
	 @Test
	 void test_guardarSuperHeroe() {
		 
		 //Comportamiento esperado del cuerpo del bucle
		 when(repository.save(superHeroeEsperado)).thenReturn(superHeroeEsperado);
		 
		 //llamada al metodo a testear
		 superHeroeActual=superHeroeService.guardarSuperHeroe(superHeroeEsperado);
		 
		 //Comprobaciones del resultado esperado
		 assertEquals(superHeroeActual.getNombre(), superHeroeEsperado.getNombre()); 
	 }
	 
	 @Test
	 void test_eliminarSuperHeroe() {
	
		 //Comportamiento esperado del cuerpo del bucle
		 doNothing().when(repository).deleteById(id);
		 
		 //llamada al metodo a testear
		 superHeroeService.eliminarSuperHeroe(id);
		 
		 //Comprobaciones del resultado esperado
		 assertTrue(repository.findById(id).isEmpty());
	 
	 }
}
