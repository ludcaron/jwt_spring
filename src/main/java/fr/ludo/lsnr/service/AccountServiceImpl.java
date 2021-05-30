package fr.ludo.lsnr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.ludo.lsnr.dao.AppRoleRepository;
import fr.ludo.lsnr.dao.AppUserRepository;
import fr.ludo.lsnr.entities.AppRole;
import fr.ludo.lsnr.entities.AppUser;

/**
 * Couche Service pour la gestion des utilisateurs
 * 
 * @author amadl
 *
 */

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	private AppUserRepository userRepository;
	@Autowired
	private AppRoleRepository roleRepository;

	@Override
	public AppUser saveUser(AppUser appUser) {
		String hashPW = bCryptPasswordEncoder.encode(appUser.getPassword());
		appUser.setPassword(hashPW);
		return userRepository.save(appUser);
	}

	@Override
	public AppRole saveRole(AppRole role) {
		return roleRepository.save(role);
	}

	@Override
	public void addRoleToUse(String username, String roleName) {
		AppRole role = roleRepository.findByRoleName(roleName);
		AppUser appUser = userRepository.findByUsername(username);
		appUser.getRoles().add(role);

	}

	@Override
	public AppUser findUserByUsername(String username) {
		return userRepository.findByUsername(username);
	}

}
