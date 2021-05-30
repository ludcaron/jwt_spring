package fr.ludo.lsnr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.ludo.lsnr.entities.AppUser;
import fr.ludo.lsnr.service.AccountService;

/**
 * API REST pour enregistrer de nouveaux utilisateurs
 * 
 * @author amadl
 *
 */
@RestController
public class AccountRestController {
	@Autowired
	private AccountService accountService;

	@PostMapping("/register")
	public AppUser register(@RequestBody RegisterForm userForm) {
		AppUser user = accountService.findUserByUsername(userForm.getUsername());
		if (user != null)
			throw new RuntimeException("This user already exists!");

		if (!userForm.getPassword().equals(userForm.getRepassword()))
			throw new RuntimeException("You must confirm your password!");

		AppUser appUser = new AppUser();
		appUser.setUsername(userForm.getUsername());
		appUser.setPassword(userForm.getPassword());
		accountService.saveUser(appUser);
		accountService.addRoleToUse(userForm.getUsername(), "USER");
		System.out.println(appUser);
		return (appUser);
	}
}
