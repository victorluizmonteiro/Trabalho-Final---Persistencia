package br.com.fiap.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Curso implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idCurso;
	@Column(name="NOME_CURSO",nullable=false)
	private String nomeCurso;
	@Column(name="CARGA_HORARIA",nullable=false)
	private int cargaHoraria;
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY,mappedBy="idCurso")
	private List<Aluno>alunos;
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="ID_FACULDADE")
	private Faculdade idFaculdade;

	public void addAluno(Aluno aluno){
		aluno.setIdCurso(this);
		alunos.add(aluno);
	}
	public int getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}

	public String getNomeCurso() {
		return nomeCurso;
	}

	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}

	public int getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}


	public Faculdade getIdFaculdade() {
		return idFaculdade;
	}

	public void setIdFaculdade(Faculdade idFaculdade) {
		this.idFaculdade = idFaculdade;
	}

	

	public Curso(int idCurso, String nomeCurso, int cargaHoraria, List<Aluno> alunos, Faculdade idFaculdade) {
		super();
		this.idCurso = idCurso;
		this.nomeCurso = nomeCurso;
		this.cargaHoraria = cargaHoraria;
		this.alunos = alunos;
		this.idFaculdade = idFaculdade;
	}

	public Curso() {
		alunos = new ArrayList<Aluno>();
	}
	
	@Override
	public String toString() {
		
		return "Nome :" + nomeCurso + "\nFaculdade: " + idFaculdade.getNome();
	}
	

}
