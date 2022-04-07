package com.example.lourdes.superheroes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.example.lourdes.superheroes.model.SuperHeroe;

public interface SuperHeroeRepository extends JpaRepository<SuperHeroe, Integer>{

	public List<SuperHeroe> findByEstado(String estado);
 
	public List<SuperHeroe> findByNombreContainingIgnoreCase(@Param("nombre") String nombre);
}