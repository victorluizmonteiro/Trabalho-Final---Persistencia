package br.com.fiap.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity

public class Faculdade {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_FACULDADE")
	private int id;
	@Column(name="NOME")
	private String nome;
	@Column(name="ENDERECO")
	private String endereco;
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY,mappedBy="idFaculdade")
	private List<Curso> cursos;
	
	public void addCurso(Curso curso){
		curso.setIdFaculdade(this);
		cursos.add(curso);
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public List<Curso> getCursos() {
		return cursos;
	}
	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}
	
	
	public Faculdade(int id, String nome, String endereco, List<Curso> cursos) {
		super();
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
		this.cursos = cursos;
	}
	public Faculdade() {
		cursos = new ArrayList<Curso>();
	}
	
	
	@Override
	public String toString() {
		
		return "Nome :" + nome + "\nEndere�o: " + endereco;
	}
	
	

}
