package br.com.course.academy.controllers;

import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

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
	private ServiceUsuario serviceUsuario;
	
	@GetMapping("/")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login/login");
		mv.addObject("usuario", new Usuario());
		return mv;
	}

	@GetMapping("/index")
	 public ModelAndView index() {
		 ModelAndView mv = new ModelAndView();//instancia o objeto Modelview
		 mv.addObject("aluno", new Aluno());
		 mv.setViewName("home/index");//mostra o caminho da pagina
		 
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
	public ModelAndView login(Usuario user, HttpSession session, BindingResult br) throws NoSuchAlgorithmException, ServiceExc {
		ModelAndView mv = new ModelAndView();
		mv.addObject("usuario", new Usuario());
		 if (br.hasErrors()) {
		 	mv.setViewName("login/login");
		 }

		 Usuario userLogin = serviceUsuario.loginUser(user.getUser(), Util.md5(user.getSenha()));
		 if (userLogin == null) {
		 	mv.addObject("msg", "Usuario não encontrado, tente novamente");
		 	mv.setViewName("login/login");
		 } else {
			    session.setAttribute("usuarioLogado", userLogin.getUser());
			    mv.setViewName("redirect:/index"); 
			}

		return mv;
}


	@PostMapping("/logout")
	public ModelAndView logout(HttpSession session) {
		session.invalidate();
		return login();
	}
}
