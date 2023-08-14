package br.com.course.academy.model;

import br.com.course.academy.Enuns.Curso;
import br.com.course.academy.Enuns.Status;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

// essa anotacao mostra que é um objeto aluno
@Entity
public class Aluno {
	
	@Id //mostra que o atributo id é o identificador da classe/banco de dados
	@GeneratedValue(strategy = GenerationType.AUTO) //essa anotacao configuro que ela vai ser autoIncremento
	private Integer id;
	
	@Column(name = "nome")//anotacao de jpa,  diz qual vai ser o nome da coluna no banco de dados
	private String nome;
	
	@Column(name = "curso")
	@Enumerated(EnumType.STRING)
	private Curso curso;
	
	@Column(name = "matricula")
	private String matricula;
	
	@Column(name = "status")
	@Enumerated(EnumType.STRING)
	private Status status;
	

	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	
	
	
	
	
	
	
	

}
