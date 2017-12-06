package br.com.fiap.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.dao.AlunoDAO;
import br.com.fiap.entity.Aluno;
import br.com.fiap.entity.Faculdade;

public class AlunoDAOImpl extends GenericDAOImpl<Aluno, Integer> implements AlunoDAO {

	public AlunoDAOImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Aluno> list() {
		TypedQuery<Aluno> query = em.createQuery("from Aluno a",Aluno.class);
		return query.getResultList();
	}

}
