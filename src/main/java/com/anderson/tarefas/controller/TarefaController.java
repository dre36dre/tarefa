package com.anderson.tarefas.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.anderson.tarefas.TarefasApplication;
import com.anderson.tarefas.model.Tarefa;
import com.anderson.tarefa.service.TarefaService;

@RestController
public class TarefaController {

    private final TarefasApplication tarefasApplication;
	
private tarefasApplicatione tarefaService;

    TarefaController(TarefasApplication tarefasApplication) {
        this.tarefasApplication = tarefasApplication;
    }
	
	@Autowired
	public void setTarefaService(TarefaService tarefaService)
	{
		this.tarefaService = tarefaService;
	}
	//Listar todos


	/*
	@GetMapping("/listarTarefas")
	public String listarTarefas(Model model)
	{
        model.addAttibute("tarefas",tarefa.listAll());
		
		return "tarefas";
	}
	*/



	//Listar por numero
	@GetMapping("/listarTarefas/{numero}")
	public String listarTarefas(@PathVariable long numero, Model model)
	{
        model.addAttibute("tarefa",tarefa.listByNumero());
		
		return "tarefas";
	}

	@GetMapping("/list/{numero}")
	public Tarefa listByNumero(@PathVariable Long numero)
	{
		Optional<Tarefa> tarefaEncontrada = tarefaService.listByNumero(numero);
		return tarefaEncontrada.get();
	}	

}