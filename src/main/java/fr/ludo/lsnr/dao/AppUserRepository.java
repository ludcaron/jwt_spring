package fr.ludo.lsnr.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.ludo.lsnr.entities.AppUser;

/**
 * Couche DAO basée sur Spring Data pour les utilisateurs
 * 
 * @author amadl
 *
 */

public interface AppUserRepository extends JpaRepository<AppUser, Long> {
	public AppUser findByUsername(String username);
}
