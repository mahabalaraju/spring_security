package com.worker.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="form_table")
public class worker {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int id;
	private String fullname;
	private String email;
	private String password;
	private String DOB;
	private String gender;
	private String profession;
	private String martialStatus;
	private String comments;
}
