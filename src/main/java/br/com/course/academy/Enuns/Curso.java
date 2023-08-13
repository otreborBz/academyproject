package br.com.course.academy.Enuns;

public enum Curso {
	
	ADMISTRACAO("Admistração"),
	INFORMATICA("Informatica"),
	CONTABILIDADE("Contabilidade"),
	PROGRAMACAO("Programação"),
	ENFERMAGEM("Enfermagem");
	
	private String curso;

	private Curso(String curso) {
		this.curso = curso;
	}

	public String getCurso() {
		return curso;
	}
	
	
	
	
	

}
