package br.com.faculdadedonaduzzi.lab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.faculdadedonaduzzi.lab.dto.TarefaDTO;
import br.com.faculdadedonaduzzi.lab.dto.TarefaReponseDTO;
import br.com.faculdadedonaduzzi.lab.entity.Task;
import br.com.faculdadedonaduzzi.lab.repository.TaskRepository;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    @Autowired
    private TaskRepository taskRepository;

    @GetMapping("/version")
    public String getVersion() {
        return "v1.0.0";
    }

    @GetMapping
    public List<TarefaReponseDTO> getTasks() {
        return taskRepository.findAll().stream().map(TarefaReponseDTO::new).toList();
    }

    @PostMapping
    public TarefaReponseDTO save(@RequestBody TarefaDTO task) {
        Task newTask = new Task();
        newTask.setTitulo(task.titulo());
        newTask.setDescricao(task.descricao());
        newTask.setStatus(task.status());
        Task savedTask = taskRepository.save(newTask);
        return new TarefaReponseDTO(savedTask);
    }

    @PutMapping("/{id}")
    public TarefaReponseDTO update(@PathVariable Long id, @RequestBody TarefaDTO task) {
        Task newTask = taskRepository.findById(id).orElseThrow();
        newTask.setTitulo(task.titulo());
        newTask.setDescricao(task.descricao());
        newTask.setStatus(task.status());
        Task savedTask = taskRepository.save(newTask);
        return new TarefaReponseDTO(savedTask);
    }
}
