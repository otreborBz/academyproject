package br.com.course.academy.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.course.academy.model.Usuario;

public interface UsuarioDAO extends JpaRepository< Usuario, Long> {

}
