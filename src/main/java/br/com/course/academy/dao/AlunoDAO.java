package br.com.course.academy.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.course.academy.model.Aluno;


public interface AlunoDAO extends JpaRepository<Aluno, Integer> {

	@Query("select r from Aluno r where r.status = 'ATIVO' ")
	public List<Aluno>findByStatusAtivos();
	
	@Query("select r from Aluno r where r.status = 'INATIVO' ")
	public List<Aluno>findByStatusInativos();

	@Query("select r from Aluno r where r.status = 'TRANCADO' ")
	public List<Aluno>findByStatusTrancados();
	
	@Query("select r from Aluno r where r.status = 'CANCELADO' ")
	public List<Aluno>findByStatusCancelados();
	
	public List<Aluno>findByNomeContainingIgnoreCase(String nome);
}
