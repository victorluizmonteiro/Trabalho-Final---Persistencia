package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.entity.Aluno;

public interface AlunoDAO extends GenericDAO<Aluno, Integer> {
	List<Aluno>list();
}
