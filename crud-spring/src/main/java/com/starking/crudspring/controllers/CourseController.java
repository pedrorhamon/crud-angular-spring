package com.starking.crudspring.controllers;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	public ResponseEntity<Long> getById(@PathParam("id") Long id) {
		this.service.getById(id);
		return ResponseEntity.ok(id);
	}
}
