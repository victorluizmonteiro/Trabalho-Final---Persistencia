package br.com.fiap.dao;

import java.util.List;

public interface GenericDAO<T,K> {
	
	void insert(T entity);
	T findById(K id);
	
	
	
	

}
