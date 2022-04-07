package com.example.lourdes.superheroes.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lourdes.superheroes.model.SuperHeroe;
import com.example.lourdes.superheroes.repository.SuperHeroeRepository;
import com.example.lourdes.superheroes.service.SuperHeroeService;

@Service
public class SuperHeroeServiceImpl implements SuperHeroeService {

	@Autowired
	private SuperHeroeRepository superHeroeRepository;

	public List<SuperHeroe> listarSuperHeroes() {
		return superHeroeRepository.findAll();
	}

	@Override
	public SuperHeroe obtenerSuperHeroe(Integer id) {
		return superHeroeRepository.findById(id).get();
	}

	@Override
	public List<SuperHeroe> buscarPorNombre(String nombre) {
		return superHeroeRepository.findByNombreContainingIgnoreCase(nombre);
	}
	
	@Override
	public List<SuperHeroe> buscarPorEstado(String idEstado) {
		return superHeroeRepository.findByEstado(idEstado);
	}

	
	@Override
	public SuperHeroe guardarSuperHeroe(SuperHeroe superHeroe) {
		return superHeroeRepository.save(superHeroe);
	}

	
	@Override
	public void eliminarSuperHeroe(Integer id) {
		superHeroeRepository.deleteById(id);
		
	}	
}
