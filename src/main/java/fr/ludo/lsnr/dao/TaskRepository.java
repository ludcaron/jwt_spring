package fr.ludo.lsnr.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.ludo.lsnr.entities.Task;

/**
 * Couche DAO basée sur Spring Data pour les taches
 * 
 * @author amadl
 *
 */

public interface TaskRepository extends JpaRepository<Task, Long> {

}
