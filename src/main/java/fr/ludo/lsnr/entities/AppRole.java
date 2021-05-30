package fr.ludo.lsnr.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entités JPA : Role
 * 
 * @author amadl
 *
 */

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppRole {
	@Id
	@GeneratedValue
	private Long id;
	private String roleName;
}
