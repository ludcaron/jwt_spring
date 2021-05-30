package fr.ludo.lsnr.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.ludo.lsnr.dao.TaskRepository;
import fr.ludo.lsnr.entities.Task;

/**
 * API REST pour gérer les taches
 * 
 * @author amadl
 *
 */
@RestController
public class TaskRestController {
	@Autowired
	private TaskRepository taskRepository;

	@GetMapping("/tasks")
	public List<Task> listTask() {
		return taskRepository.findAll();
	}

	@PostMapping("/tasks")
	public Task save(@RequestBody Task task) {
		return taskRepository.save(task);
	}

}
