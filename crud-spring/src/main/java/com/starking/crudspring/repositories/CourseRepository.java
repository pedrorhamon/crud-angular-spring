package com.starking.crudspring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.starking.crudspring.model.Course;

public interface CourseRepository extends JpaRepository<Course, Long>{}
