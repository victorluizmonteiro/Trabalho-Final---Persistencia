package br.com.fiap.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.dao.FaculdadeDAO;
import br.com.fiap.entity.Faculdade;

public class FaculdadeDAOImpl extends GenericDAOImpl<Faculdade, Integer> implements FaculdadeDAO {

	public FaculdadeDAOImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Faculdade> list() {
		TypedQuery<Faculdade> query = em.createQuery("from Faculdade f",Faculdade.class);
		return query.getResultList();
		
	}

}
