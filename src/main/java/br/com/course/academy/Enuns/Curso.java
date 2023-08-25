package br.com.course.academy.Enuns;

public enum Curso {
	
	ADMISTRACAO("ADMINISTRACAO"),
	INFORMATICA("INFORMATICA"),
	CONTABILIDADE("CONTABILIDADE"),
	PROGRAMACAO("PROGRAMACAO"),
	ENFERMAGEM("ENFERMAGEM");
	
	private String curso;

	private Curso(String curso) {
		this.curso = curso;
	}

	public String getCurso() {
		return curso;
	}
	
	
	
	
	

}
