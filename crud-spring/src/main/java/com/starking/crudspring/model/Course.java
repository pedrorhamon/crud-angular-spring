package com.starking.crudspring.model;

import javax.persistence.*;

import lombok.Data;

@Entity
@Data
@Table(name = "course")
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 200, nullable = false)
	private String name;
	
	@Column(length = 10, nullable = false)
	private String category;
}
