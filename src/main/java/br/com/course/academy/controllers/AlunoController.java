package br.com.course.academy.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.course.academy.dao.AlunoDAO;
import br.com.course.academy.model.Aluno;
import jakarta.validation.Valid;




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
	 public ModelAndView inserirAluno(@Valid Aluno aluno,BindingResult br ){
		ModelAndView mv = new ModelAndView();
		if(br.hasErrors()) {
			mv.setViewName("aluno/formAluno");
			mv.addObject("aluno");
		}else {
			mv.setViewName("redirect:/alunos-adicionados");
			alunoRepositorio.save(aluno);
		}
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
		  Aluno aluno = alunoRepositorio.findById(id).orElse(null);
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

	  @GetMapping("filtro-alunos")
	   public ModelAndView filtroAlunos(Aluno aluno) {
		  ModelAndView mv = new ModelAndView();
		  mv.setViewName("aluno/filtroAlunos");	
		 return mv;
	  }
	  
	  
	  @GetMapping("alunos-ativos")
	 public ModelAndView listaAlunosAtivos() {
		 ModelAndView mv = new ModelAndView();
		 mv.setViewName("aluno/alunos-ativos");
		 mv.addObject("alunosAtivos", alunoRepositorio.findByStatusAtivos());
		return mv;
	 }
	  @GetMapping("alunos-inativos")
		 public ModelAndView listaAlunosInativos() {
			 ModelAndView mv = new ModelAndView();
			 mv.setViewName("aluno/alunos-inativos");
			 mv.addObject("alunosInativos", alunoRepositorio.findByStatusInativos());
			return mv;
		 }
	  @GetMapping("alunos-cancelados")
		 public ModelAndView listaAlunosCancelados() {
			 ModelAndView mv = new ModelAndView();
			 mv.setViewName("aluno/alunos-cancelados");
			 mv.addObject("alunosCancelados", alunoRepositorio.findByStatusCancelados());
			return mv;
		 }
	  @GetMapping("alunos-trancados")
		 public ModelAndView listaAlunosTrancados() {
			 ModelAndView mv = new ModelAndView();
			 mv.setViewName("aluno/alunos-trancados");
			 mv.addObject("alunosTrancados", alunoRepositorio.findByStatusTrancados());
			return mv;
		 }
	  
	  @PostMapping("pesquisar-aluno")
	  public ModelAndView pesquisaraluno(@RequestParam(required=false) String nome) {
		  ModelAndView mv = new ModelAndView();
		  List<Aluno> listaAlunos;
		  if(nome == null || nome.trim().isEmpty()) {
			  listaAlunos = alunoRepositorio.findAll();
		  }else {
			  listaAlunos = alunoRepositorio.findByNomeContainingIgnoreCase(nome);
		  }
		  mv.addObject("ListaDeAlunos", listaAlunos);
		  mv.setViewName("aluno/pesquisa-resultado");		  
		 return mv;
	  }
	  
    
}
