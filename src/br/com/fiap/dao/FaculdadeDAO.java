package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.entity.Faculdade;

public interface FaculdadeDAO extends GenericDAO<Faculdade, Integer> {
	List<Faculdade> list();
}
