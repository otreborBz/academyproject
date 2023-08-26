package br.com.course.academy.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.course.academy.model.Usuario;

public interface UsuarioDAO extends JpaRepository< Usuario, Long> {
	
	@Query("select i from Usuario i where i.email = :email")
	public Usuario findByEmail(String email);

}
