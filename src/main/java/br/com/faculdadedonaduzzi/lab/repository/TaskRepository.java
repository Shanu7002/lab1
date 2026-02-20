package br.com.faculdadedonaduzzi.lab.repository;

import br.com.faculdadedonaduzzi.lab.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
