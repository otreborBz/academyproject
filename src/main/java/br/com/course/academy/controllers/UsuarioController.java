package br.com.course.academy.controllers;

import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.course.academy.dao.UsuarioDAO;
import br.com.course.academy.model.Aluno;
import br.com.course.academy.model.Usuario;
import br.com.course.academy.service.ServiceExc;
import br.com.course.academy.service.ServiceUsuario;
import br.com.course.academy.util.Util;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

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
	@GetMapping("/index")
	 public ModelAndView index() {
		 ModelAndView mv = new ModelAndView();//instancia o objeto Modelview
		 mv.setViewName("home/index");//mostra o caminho da pagina
		 mv.addObject("aluno", new Aluno());
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
	

	
	@PostMapping("/login")
	public ModelAndView login(@Valid Usuario usuario, BindingResult br, HttpSession session) throws NoSuchAlgorithmException, ServiceExc{
		ModelAndView mv = new ModelAndView();
		mv.addObject("usuario", new Usuario());
		if(br.hasErrors()) {
			mv.setViewName("login/login");
		}
		
		Usuario userLogin = serviceUsuario.loginUser(usuario.getUser(), Util.md5(usuario.getSenha()));
		if(userLogin == null) {
			mv.addObject("msg", "Usuario não encontrado, tente novamente");
		}else {
			session.setAttribute("usuarioLogado", userLogin);
			return index();
		}
		return mv;
	}

	@PostMapping("/logout")
	public ModelAndView logout(HttpSession session) {
		session.invalidate();
		return login();
	}
}
