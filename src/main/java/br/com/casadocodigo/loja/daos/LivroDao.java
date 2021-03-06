package br.com.casadocodigo.loja.daos;

import java.util.List;

//import javax.annotation.Resource;
import javax.persistence.EntityManager;


import javax.persistence.PersistenceContext;
//import javax.transaction.UserTransaction;

import br.com.casadocodigo.loja.models.Livro;

public class LivroDao {
	@PersistenceContext
	private EntityManager manager;
	
	//@Resource
	//private UserTransaction transaction;

	public void salvar(Livro livro) {
		manager.persist(livro);		
	}

	public List<Livro> listar() {
		String jpql = "select distinct(l) from Livro l join fetch l.autores";
		return manager.createQuery(jpql, Livro.class).getResultList();
	}
}
