package br.com.fiap.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.dao.CursoDAO;
import br.com.fiap.entity.Curso;
import br.com.fiap.entity.Faculdade;

public class CursoDAOImpl  extends GenericDAOImpl<Curso, Integer> implements CursoDAO{

	public CursoDAOImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Curso> list() {
		TypedQuery<Curso> query = em.createQuery("from Curso c",Curso.class);
		return query.getResultList();
	}

}
