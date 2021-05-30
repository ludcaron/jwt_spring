package fr.ludo.lsnr.service;

import fr.ludo.lsnr.entities.AppRole;
import fr.ludo.lsnr.entities.AppUser;

public interface AccountService {
	public AppUser saveUser(AppUser user);

	public AppRole saveRole(AppRole role);

	public void addRoleToUse(String username, String roleName);

	public AppUser findUserByUsername(String username);
}
