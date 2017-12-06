package br.com.fiap.main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.swing.JOptionPane;

import br.com.fiap.dao.AlunoDAO;
import br.com.fiap.dao.CursoDAO;
import br.com.fiap.dao.FaculdadeDAO;
import br.com.fiap.dao.impl.AlunoDAOImpl;
import br.com.fiap.dao.impl.CursoDAOImpl;
import br.com.fiap.dao.impl.FaculdadeDAOImpl;
import br.com.fiap.entity.Aluno;
import br.com.fiap.entity.Curso;
import br.com.fiap.entity.Faculdade;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class Main {

	public static void main(String[] args) {
		
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		FaculdadeDAO faculdadeDao = new FaculdadeDAOImpl(em);
		AlunoDAO alunoDao = new AlunoDAOImpl(em);
		CursoDAO cursoDao = new CursoDAOImpl(em);
		
		//Criando Alunos
		Aluno a1 = new Aluno();
		a1.setNome(JOptionPane.showInputDialog("Digite o nome Do aluno 1"));
		a1.setIdade(Integer.parseInt(JOptionPane.showInputDialog("Digite a idade Do aluno 1")));
		a1.setCpf(JOptionPane.showInputDialog("Digite o cpf Do aluno 1"));
		
		//Criando Cursos
				Curso c1 = new Curso();
				c1.setNomeCurso(JOptionPane.showInputDialog("Digite o nome do curso DO ALUNO 1"));
				c1.setCargaHoraria(Integer.parseInt(JOptionPane.showInputDialog("Digite a carga horária do curso DO ALUNO 1 ")));
				
		
		Aluno a2 = new Aluno();
		a2.setNome(JOptionPane.showInputDialog("Digite o nome Do aluno 2"));
		a2.setIdade(Integer.parseInt(JOptionPane.showInputDialog("Digite a idade Do aluno 2")));
		a2.setCpf(JOptionPane.showInputDialog("Digite o cpf Do aluno 2"));
		
		
		
		
		Curso c2 = new Curso();
		c2.setNomeCurso(JOptionPane.showInputDialog("Digite o nome do curso DO ALUNO 2"));
		c2.setCargaHoraria(Integer.parseInt(JOptionPane.showInputDialog("Digite a carga horária do curso DO ALUNO 2")));
		
		
		
		//Relacionando Cursos com alunos
		c1.addAluno(a1);
		c2.addAluno(a2);
		
		cursoDao.insert(c1);
		cursoDao.insert(c2);
		//Criando Faculdades
		Faculdade f1 = new Faculdade();
		f1.setNome(JOptionPane.showInputDialog("Digite o nome da faculdade DO CURSO 1"));
		f1.setEndereco(JOptionPane.showInputDialog("Digite o endereço da faculdade DO CURSO 1"));
		
		Faculdade f2 = new Faculdade();
		f2.setNome(JOptionPane.showInputDialog("Digite o nome da faculdade DO CURSO 2"));
		f2.setEndereco(JOptionPane.showInputDialog("Digite o endereço da faculdade DO CURSO 2"));
		
		//Relacionando Faculdade com cursos
		f1.addCurso(c1);
		f2.addCurso(c2);
		
		faculdadeDao.insert(f1);
		faculdadeDao.insert(f2);
		
		List<Curso>cursos = cursoDao.list();
		List<Faculdade>faculdades = faculdadeDao.list();
		List<Aluno>alunos = alunoDao.list();
		cursos.stream().forEach(System.out::println);
		faculdades.stream().forEach(System.out::println);
		alunos.stream().forEach(System.out::println);
		
		Aluno findAluno = alunoDao.findById(a1.getIdAluno());
		Curso findCurso = cursoDao.findById(c1.getIdCurso());
		Faculdade findFacul = faculdadeDao.findById(f1.getId());
		
		System.out.println("Aluno 1 : " + findAluno.getNome());
		System.out.println("Curso 1 : " + findCurso.getNomeCurso());
		System.out.println("Faculdade 1 :" + findFacul.getNome());
		
		
		

	}

}
