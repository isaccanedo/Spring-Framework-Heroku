package com.isaccanedo.tutorial.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isaccanedo.tutorial.domain.Categoria;

/*
 * Na classe herdada 'JpaRepository', o pirmeiro parâmetro representa
 * o tipo do objeto que será lidado pelo repositório e o segundo, o 
 * tipo do identificador do objeto. Como em categoria, o ID do tipo 
 * Integer é o identificador da classe, então o tipo será Integer.
 */
@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{
	
}
