package com.example.lourdes.superheroes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.lourdes.superheroes.model.SuperHeroe;
import com.example.lourdes.superheroes.service.SuperHeroeService;

@RestController
public class SuperHeroeController {

	@Autowired 
	private SuperHeroeService superHeroeService;
	
	@GetMapping(value = "superheroes", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<SuperHeroe> consultarSuperHeroes() {
		return superHeroeService.listarSuperHeroes();
	}
	
	@GetMapping(value = "superheroes/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public SuperHeroe consultarSuperHeroes(@PathVariable Integer id) {
		return superHeroeService.obtenerSuperHeroe(id);
	}
	
	@GetMapping(value = "superheroes/nombre/{nombre}" , produces = MediaType.APPLICATION_JSON_VALUE)
	public List<SuperHeroe> consultarPorNombre(@PathVariable(name = "nombre") String nombre) {
		return superHeroeService.buscarPorNombre(nombre);
	}
	
	@GetMapping(value = "superheroes/estado/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<SuperHeroe> consultarPorEstado(@PathVariable(name = "id") String estado) {
		return superHeroeService.buscarPorEstado(estado);
	}
	
	@PostMapping(value = "superheroes", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public SuperHeroe crearSuperHeroe(@RequestBody SuperHeroe superHeroe) {
		superHeroe.setId(null);
		return superHeroeService.guardarSuperHeroe(superHeroe);
	}
	
	@PutMapping(value = "superheroes/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public SuperHeroe modificarSuperHeroe(@PathVariable Integer id, @RequestBody SuperHeroe superHeroe) {
		superHeroe.setId(id);
		return superHeroeService.guardarSuperHeroe(superHeroe);
	}
	
	@PatchMapping(value = "superheroes/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public SuperHeroe modificarEstadoSuperHeroe(@PathVariable Integer id, @RequestBody SuperHeroe superHeroeDetails) {
		SuperHeroe superHeroe= superHeroeService.obtenerSuperHeroe(id);
		superHeroe.setEstado(superHeroeDetails.getEstado());
		return superHeroeService.guardarSuperHeroe(superHeroe);
	}
	
	@DeleteMapping(value = "superheroes/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void eliminarSuperHeroe(@PathVariable(name = "id") Integer id) {
		superHeroeService.eliminarSuperHeroe(id);
	}
}
