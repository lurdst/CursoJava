package com.example.lourdes.superheroes.service;

import java.util.List;

import com.example.lourdes.superheroes.model.SuperHeroe;

public interface SuperHeroeService {
	List<SuperHeroe> listarSuperHeroes();
	SuperHeroe obtenerSuperHeroe(Integer id);
	SuperHeroe guardarSuperHeroe(SuperHeroe superHeroe);
	List<SuperHeroe> buscarPorEstado(String estado);
	void eliminarSuperHeroe(Integer id);
	List<SuperHeroe> buscarPorNombre(String nombre);
}
