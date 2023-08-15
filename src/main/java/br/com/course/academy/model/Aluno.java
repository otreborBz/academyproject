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
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
// essa anotacao mostra que é um objeto aluno
@Entity
public class Aluno {
	
	@Id //mostra que o atributo id é o identificador da classe/banco de dados
	@GeneratedValue(strategy = GenerationType.AUTO) //essa anotacao configuro que ela vai ser autoIncremento
	private Integer id;
	
	@Column(name = "nome")//anotacao de jpa,  diz qual vai ser o nome da coluna no banco de dados
	@Size(min=5, max=35, message="O nome deve conter mais que 5 caracter")//validar os campos no lado servidor
	@NotBlank(message = "O nome não pode estar vazio")
	private String nome;
	
	@Column(name = "curso")
	@Enumerated(EnumType.STRING)
	@NotNull(message="O campo curso não pode ser nulo")
	private Curso curso;
	
	@Column(name = "matricula")
	@NotNull(message="Click no botão gerar")
	@Size(min=1, max=15, message="Click no botão gerar")
	private String matricula;
	
	@Column(name = "status")
	@Enumerated(EnumType.STRING)//mostra como deve ser salvo no banco de dados, nesse caso como string
	@NotNull(message="O campo status não pode ser nulo")
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
