package br.com.course.academy.service;

import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.course.academy.Exception.CriptoExistsException;
import br.com.course.academy.Exception.EmailExistsException;
import br.com.course.academy.dao.UsuarioDAO;
import br.com.course.academy.model.Usuario;
import br.com.course.academy.util.Util;
	
@Service
public class ServiceUsuario{
	
	@Autowired
	private UsuarioDAO repositorioUsuario;
	
	public void salvarUsuario(Usuario usuario) throws Exception {
		try {
			if(repositorioUsuario.findByEmail(usuario.getEmail()) != null) {
				throw new EmailExistsException("Email ja cadastrado para o usuario: "+usuario.getUser());
			}
			usuario.setSenha(Util.md5(usuario.getSenha()));
		} catch (NoSuchAlgorithmException e) {
			throw new CriptoExistsException("Erro na criptografia da senha");
		}
		repositorioUsuario.save(usuario);
	}

	

}
