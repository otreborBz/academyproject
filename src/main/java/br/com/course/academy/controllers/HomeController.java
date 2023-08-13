package br.com.course.academy.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	
	@GetMapping("/")
	 public ModelAndView index() {
		 ModelAndView mv = new ModelAndView();//instancia o objeto Modelview
		 mv.setViewName("home/index");//seta o nome 
		 mv.addObject("msg", "mensagem vinda diretamente do controle");
		 return mv;
	 }

}
