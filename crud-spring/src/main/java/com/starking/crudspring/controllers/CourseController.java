package com.starking.crudspring.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.starking.crudspring.model.Course;
import com.starking.crudspring.repositories.CourseRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/courses")
@RequiredArgsConstructor
public class CourseController {
	
	private final CourseRepository repository;

	@GetMapping
	public List<Course> list() {
		return this.repository.findAll();
	}
	
	@PostMapping
	public ResponseEntity<Course> save() {
		return ResponseEntity.accepted().build();
	}
}
