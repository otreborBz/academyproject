package br.com.course.academy.Enuns;

public enum Status {
	
	ATIVO("ATIVO"),
	INATIVO("INATIVO"),
	TRANCADO("TRANCADO"),
	CANCELADO("CANCELADO");
	
	private String status;

	private Status(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

}
