package br.com.faculdadedonaduzzi.lab.dto;

import br.com.faculdadedonaduzzi.lab.entity.Task;
import br.com.faculdadedonaduzzi.lab.entity.TaskStatus;

import jakarta.validation.constraints.NotBlank;

public record TarefaDTO(
        @NotBlank String titulo,
        @NotBlank String descricao,
        TaskStatus status
) {
    public TarefaDTO(Task task){
        this(task.getTitulo(), task.getDescricao(), task.getStatus());
    }
}