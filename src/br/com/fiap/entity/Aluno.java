package br.com.fiap.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Aluno implements Serializable {
	
	private static final long serialVersionUID = 1L;
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name="ID_ALUNO")
		private int idAluno;
		@Column(name="NOME_ALUNO",nullable=false)
		private String nome;
		@Column(name="IDADE",nullable=false)
		private int idade;
		@Column(name="CPF")
		private String cpf;
		@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
		@JoinColumn(name="ID_CURSO")
		private Curso idCurso;
		public int getIdAluno() {
			return idAluno;
		}
		public void setIdAluno(int idAluno) {
			this.idAluno = idAluno;
		}
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public int getIdade() {
			return idade;
		}
		public void setIdade(int idade) {
			this.idade = idade;
		}
		public String getCpf() {
			return cpf;
		}
		public void setCpf(String cpf) {
			this.cpf = cpf;
		}
	
		
		public Curso getIdCurso() {
			return idCurso;
		}
		public void setIdCurso(Curso idCurso) {
			this.idCurso = idCurso;
		}
		
		
		public Aluno(int idAluno, String nome, int idade, String cpf, Curso idCurso) {
			super();
			this.idAluno = idAluno;
			this.nome = nome;
			this.idade = idade;
			this.cpf = cpf;
			this.idCurso = idCurso;
		}
		public Aluno() {
			super();
		}
		
		@Override
		public String toString() {
			
			return "Nome: " + nome + "\n Cpf: "  + cpf ;
		}
		
		
}
