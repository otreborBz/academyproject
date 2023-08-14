package br.com.course.academy.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.course.academy.model.Aluno;

public interface AlunoDAO extends JpaRepository<Aluno, Integer> {

}
