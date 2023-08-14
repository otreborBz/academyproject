package br.com.course.academy.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.course.academy.dao.AlunoDAO;
import br.com.course.academy.model.Aluno;

@Controller
public class AlunoController {
	
	@Autowired
	private AlunoDAO alunoRepositorio;

    @GetMapping("/inserirAlunos")
	 public ModelAndView insertAlunos(Aluno aluno) {
		 ModelAndView mv = new ModelAndView();//instancia o objeto ModelAndView
		 mv.setViewName("aluno/formAluno");//mostra o caminho da pagina
		 mv.addObject("aluno", new Aluno());
		return mv;
	 }


	 @PostMapping("InsertAlunos")
	 public ModelAndView inserirAluno(Aluno aluno){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/aluno/ListAlunos");
		alunoRepositorio.save(aluno);
		return mv;
	 }
    
}
