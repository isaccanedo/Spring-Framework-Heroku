package com.isaccanedo.tutorial.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.isaccanedo.tutorial.domain.Categoria;
import com.isaccanedo.tutorial.domain.Produto;
import com.isaccanedo.tutorial.repositories.CategoriaRepository;
import com.isaccanedo.tutorial.repositories.ProdutoRepository;
import com.isaccanedo.tutorial.services.exceptions.ObjectNotFoundException;

@Service
public class ProdutoService {

	/*
	 * Quando se declara uma dependência e é acrescentado a anotação 'Autowired', a
	 * dependência é instanciada automaticamente pelo Spring.
	 */
	@Autowired
	private ProdutoRepository repo;

	@Autowired
	private CategoriaRepository categoriaRepository;

	public Produto find(Integer id) {
		Optional<Produto> obj = repo.findById(id);

		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! ID: " + id + ". " + "Tipo: " + Produto.class.getName()));
	}

	public Page<Produto> search(String nome, List<Integer> ids, Integer page, Integer linesPerPage, String orderBy,
			String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		List<Categoria> categorias = categoriaRepository.findAllById(ids);
		return repo.findDistinctByNomeContainingAndCategoriasIn(nome, categorias, pageRequest);
	}
}
