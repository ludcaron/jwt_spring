package fr.ludo.lsnr;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import fr.ludo.lsnr.dao.TaskRepository;
import fr.ludo.lsnr.entities.AppRole;
import fr.ludo.lsnr.entities.AppUser;
import fr.ludo.lsnr.entities.Task;
import fr.ludo.lsnr.service.AccountService;

@SpringBootApplication
public class JwtSpringSecurityApplication implements CommandLineRunner {
	@Autowired
	private TaskRepository taskRepository;
	@Autowired
	private AccountService accountService;

	public static void main(String[] args) {
		SpringApplication.run(JwtSpringSecurityApplication.class, args);
	}

	@Bean
	public BCryptPasswordEncoder getBCPE() {
		return new BCryptPasswordEncoder();
	}

	@Override
	public void run(String... args) throws Exception {
		accountService.saveUser(new AppUser(null, "admin", "1234", null));
		accountService.saveUser(new AppUser(null, "user", "1234", null));
		accountService.saveRole(new AppRole(null, "ADMIN"));
		accountService.saveRole(new AppRole(null, "USER"));
		accountService.addRoleToUse("admin", "ADMIN");
		accountService.addRoleToUse("admin", "USER");
		accountService.addRoleToUse("user", "USER");

		Stream.of("T1", "T2", "T3", "Faire ses devoirs", "Faire les courses", "Obéir").forEach((t) -> {
			taskRepository.save(new Task(null, t));
		});
		taskRepository.findAll().forEach(t -> {
			System.out.println(t.getTaskName());
		});
	}

}
