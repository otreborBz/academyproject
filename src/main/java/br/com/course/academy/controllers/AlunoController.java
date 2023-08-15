package br.com.course.academy.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
		mv.setViewName("redirect:/alunos-adicionados");
		alunoRepositorio.save(aluno);
		return mv;
	 }

	  @GetMapping("alunos-adicionados")
	 public ModelAndView listagemAlunos() {
		 ModelAndView mv = new ModelAndView();
		 mv.setViewName("aluno/listAlunos");
		 mv.addObject("alunosList", alunoRepositorio.findAll());
		return mv;
	 }
	  
	  @GetMapping("/alterar/{id}")
	  public ModelAndView alterar(@PathVariable("id") Integer id) {
		  ModelAndView mv = new ModelAndView();
		  mv.setViewName("aluno/alterar");
		  Aluno aluno = alunoRepositorio.getOne(id);
		  mv.addObject("aluno", aluno);
		  return mv;
	  }
	  
	  @PostMapping("/alterar")
	  public ModelAndView alterar(Aluno aluno) {
		  ModelAndView mv = new ModelAndView();
		 alunoRepositorio.save(aluno);
		 mv.setViewName("redirect:/alunos-adicionados");
		 return mv;
	  }
	  
    
}
