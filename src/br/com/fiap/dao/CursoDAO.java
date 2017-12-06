package br.com.fiap.dao;

import java.util.List;


import br.com.fiap.entity.Curso;

public interface CursoDAO extends GenericDAO<Curso, Integer> {
	List<Curso>list();
}
