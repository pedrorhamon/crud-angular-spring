package com.starking.crudspring.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.starking.crudspring.model.Course;
import com.starking.crudspring.services.CourseService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/courses")
@RequiredArgsConstructor
public class CourseController {
	
	private final CourseService service;

	@GetMapping
	public List<Course> list() {
		return this.service.findAll();
	}
	
	@PostMapping
	public ResponseEntity<Course> save(@RequestBody Course course) {
		Course courseEntity = this.service.save(course);
		return ResponseEntity.status(HttpStatus.CREATED).body(courseEntity);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Course> findById(@PathVariable Long id) {
		return this.service.getById(id)
				.map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Course> update(@PathVariable("id") Long id, Course course) {
		this.service.update(id, course);
		return ResponseEntity.noContent().build();
	}
}
