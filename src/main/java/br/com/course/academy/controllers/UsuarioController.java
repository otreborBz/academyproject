package br.com.course.academy.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.course.academy.dao.UsuarioDAO;
import br.com.course.academy.model.Usuario;
import br.com.course.academy.service.ServiceUsuario;

@Controller
public class UsuarioController {
	
	@Autowired
	private UsuarioDAO usuarioRepositorio;
	@Autowired
	private ServiceUsuario serviceUsuario;
	
	@GetMapping("/")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login/login");
		return mv;
	}

	@GetMapping("/cadastro")
	public ModelAndView cadastrar() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("usuario", new Usuario());
		mv.setViewName("login/cadastro");
		return mv;
	}

	@PostMapping("salvarUsuario")
	public ModelAndView cadastrar(Usuario usuario) throws Exception{
		ModelAndView mv = new ModelAndView();
		serviceUsuario.salvarUsuario(usuario);
		mv.setViewName("redirect:/");
		return mv;
	}

}
