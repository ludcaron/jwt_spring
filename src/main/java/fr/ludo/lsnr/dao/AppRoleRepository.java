package fr.ludo.lsnr.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.ludo.lsnr.entities.AppRole;

/**
 * Couche DAO basée sur Spring Data pour les roles
 * 
 * @author amadl
 *
 */

public interface AppRoleRepository extends JpaRepository<AppRole, Long> {
	public AppRole findByRoleName(String roleName);
}
